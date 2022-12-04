package pairmatching.constant.information;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {

    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Collections.emptyList());

    private static final String COLON = ": ";
    private static final String DASH = "- ";
    private static final String MISSION_DELIMITER = " | ";

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> missions = getMissions();
        stringBuilder.append(DASH + getName() + COLON);
        for (int i = 0; i < missions.size(); i++) {
            stringBuilder.append(missions.get(i));
            if (i == missions.size() - 1) {
                break;
            }
            stringBuilder.append(MISSION_DELIMITER);
        }
        return stringBuilder.toString();
    }

}
