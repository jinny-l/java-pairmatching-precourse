package pairmatching.constant.information;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import pairmatching.constant.message.ErrorMessage;

// TODO: 고민 요소 - 레벨과 미션을 어떤식으로 나누고 연결 시킬지..?
public enum Mission {

    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Collections.emptyList());

    private static final String DASH = "- ";
    private static final String LEVEL_DELIMITER = ": ";
    private static final String MISSION_DELIMITER = " | ";

    private final String level;
    private final List<String> missions;

    Mission(String level, List<String> missions) {
        this.level = level;
        this.missions = missions;
    }

    public String getLevel() {
        return level;
    }

    public List<String> getMissions() {
        return missions;
    }

    public static Mission levelFrom(String input) {
        return Stream.of(Mission.values())
                .filter(mission -> mission.level.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LEVEL.toString()));
    }

    public static boolean hasMission(Mission level, String input) {
        return level.getMissions().contains(input);
    }

    @Override
    public String toString() {
        return DASH
                + level
                + LEVEL_DELIMITER
                + String.join(MISSION_DELIMITER, missions)
                + "\n";
    }

}
