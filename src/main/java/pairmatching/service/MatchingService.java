package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.domain.MatchingInformation;
import pairmatching.domain.Pair;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingInformationRepository;
import pairmatching.repository.PairRepository;

public class MatchingService {

    private static final String PAIR_DELIMITER = " : ";

    private final MatchingInformation matchingInformation;
    private final List<List<String>> matchingResult = new ArrayList<>();
    private List<String> shuffledCrew;

    public MatchingService(List<String> matchingInformation) {
        this.matchingInformation = new MatchingInformation(matchingInformation);
    }

    public List<List<String>> matchingResult() {
        return matchingResult;
    }

    public boolean isMatched() {
        return MatchingInformationRepository.contains(matchingInformation);
    }

    public void shuffleAndMatch() {
        MatchingInformationRepository.add(this.matchingInformation);
        List<String> crews = CrewRepository.getNamesOf(matchingInformation.getCourse());
        shuffledCrew = Randoms.shuffle(crews);
        matching();
    }

    private void matching() {
        for (int i = 0; i < shuffledCrew.size() - 1; i += 2) {
            if (shuffledCrew.size() % 2 != 0 && i == (shuffledCrew.size() - 3)) {
                matchingResult.add(Arrays.asList(
                        shuffledCrew.get(i),
                        shuffledCrew.get(i + 1),
                        shuffledCrew.get(i + 2)));
                break;
            }
            matchingResult.add(Arrays.asList(
                    shuffledCrew.get(i),
                    shuffledCrew.get(i + 1)));
        }
        PairRepository.add(new Pair(matchingInformation.getLevel(), matchingInformation.getMission(), matchingResult));
    }

    public void rematch() {
        int index = MatchingInformationRepository.indexOf(matchingInformation);
        System.out.println(index);
        PairRepository.remove(index); //TODO: 디버깅 필요
        MatchingInformationRepository.removeOf(matchingInformation);
        MatchingInformationRepository.add(matchingInformation);
        shuffleAndMatch();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> pair : matchingResult) {
            for (int j = 0; j < pair.size(); j++) {
                stringBuilder.append(pair.get(j));
                if (j == pair.size() - 1) {
                    stringBuilder.append("\n");
                    continue;
                }
                stringBuilder.append(PAIR_DELIMITER);
            }
        }
        return stringBuilder.toString();
    }

}
