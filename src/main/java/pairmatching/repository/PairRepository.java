package pairmatching.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchingInfo;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.util.FileReader;

public class PairRepository {

    private static final List<Pair> PAIRS = new ArrayList<>();

    private static List<Crew> readCrewsFromFile(Course course, String filePath) {
        return FileReader.read(filePath).stream()
                .map(name -> new Crew(course, name))
                .toList();
    }

    public void add(Pair pair) {
        PAIRS.add(pair);
    }

    public int countByCourse(Course course) {
        return (int) PAIRS.stream()
                .filter(crew -> crew.getCourse() == course)
                .count();
    }

    public Pair findLastPair() {
        return PAIRS.get(PAIRS.size() - 1);
    }

    public List<Pair> findAll() {
        return Collections.unmodifiableList(PAIRS);
    }

    public boolean exists(Mission mission, List<Crew> crews) {
        return PAIRS.stream()
                .anyMatch(pair -> pair.getMission() == mission && pair.hasCrew(crews));
    }

    public List<Pair> findAllBy(Course course, Mission mission) {
        return PAIRS.stream()
                .filter(pair -> pair.getCourse() == course && pair.getMission() == mission)
                .collect(Collectors.toList());
    }

    public boolean existsMatching(MatchingInfo matchingInfo) {
        return PAIRS.stream()
                .anyMatch(pair -> pair.getCourse() == matchingInfo.getCourse() && pair.getMission() == matchingInfo.getMission());
    }

    public void clear() {
        PAIRS.clear();
    }
}
