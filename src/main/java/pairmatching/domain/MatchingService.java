package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchingService {

    private static final String PAIR_DELIMITER = " : ";

    private String course;
    private String level;
    private String mission;
    private List<String> crewNames;
    private List<String> shuffledCrew;
    private List<List<String>> matchingResult = new ArrayList<>();

    public MatchingService(List<String> information) {
        course = information.get(0);
        level = information.get(1);
        mission = information.get(2);
        crewNames = Crews.getNamesOf(course);
        shuffledCrew = Randoms.shuffle(crewNames);
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
