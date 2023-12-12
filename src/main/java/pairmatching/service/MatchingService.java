package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingInfo;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairRepository;

public class MatchingService {

    private final MissionRepository missionRepository = new MissionRepository();
    private final CrewRepository crewRepository = new CrewRepository();
    private final PairRepository pairRepository = new PairRepository();

    public void matching(Course course, Mission mission) {
        int matchingCount = 1;

        while (matchingCount <= 3) {
            try {
                matchingPair(course, mission);
                break;
            } catch (IllegalArgumentException e) {
                matchingCount++;
            }
        }
        if (matchingCount > 3) {
            throw new IllegalArgumentException("매칭 시도 초과");
        }
    }

    private void matchingPair(Course course, Mission mission) {
        List<String> randomCrewNames = randomMatching(course);

        for (int i = 0; i < randomCrewNames.size(); i += 2) {
            // 홀수인 경우 마지막 페어에 추가
            if (isOneLeft(course)) {
                Pair pair = pairRepository.findLastPair();
                Crew unMatchedCrew = crewRepository.findUnMatched();
                pair.addCrew(unMatchedCrew);
            }

            // 홀수가 아닌 경우
            Crew firstCrew = crewRepository.findByName(randomCrewNames.get(i));
            Crew secondCrew = crewRepository.findByName(randomCrewNames.get(i + 1));
            List<Crew> crews = List.of(firstCrew, secondCrew);

            // 이미 매칭된 크루인지 확인
            if (crews.stream().anyMatch(Crew::getIsMatched) || pairRepository.exists(mission, crews)) {
                throw new IllegalArgumentException("이미 매칭된 크루입니다.");
            }


            // 정삭 매칭 경우
            Pair pair = new Pair(mission, crews);
            pair.setMatched(true);
            pairRepository.add(pair);
        }
    }

    private List<String> randomMatching(Course course) {
        List<String> crewNames = crewRepository.findCrewNamesByCourse(course);
        return Randoms.shuffle(crewNames);
    }

    private boolean isOneLeft(Course course) {
        int crewCount = crewRepository.countByCourse(course);
        int pairCount = pairRepository.countByCourse(course);
        return crewCount - pairCount == 1;
    }

    public Map<Level, List<String>> findMissions() {
        return missionRepository.findAll();
    }

    public List<Pair> getPairs() {
        return pairRepository.findAll();
    }

    public List<Pair> findPairsBy(MatchingInfo matchingInfo) {
        Course course = matchingInfo.getCourse();
        Mission mission = matchingInfo.getMission();

        return pairRepository.findAllBy(course, mission);
    }

    public void resetPair() {
        pairRepository.clear();
    }
}
