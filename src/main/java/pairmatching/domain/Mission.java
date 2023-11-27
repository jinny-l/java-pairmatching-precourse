package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Mission {

    // 레벨1
    RACING_CAR("자동차경주", Level.ONE),
    LOTTO("로또", Level.ONE),
    BASEBALL("숫자야구게임", Level.ONE),

    // 레벨2
    SHOPPING_CART("장바구니", Level.TWO),
    PAYMENT("결제", Level.TWO),
    SUBWAY_MAP("지하철노선도", Level.TWO),

    // 레벨4
    PERFORMANCE_IMPROVEMENT("성능개선", Level.FOUR),
    DEPLOYMENT("배포", Level.FOUR);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission from(String missionName, String levelName) {
        return Arrays.stream(Mission.values())
                .filter(mission ->
                        Objects.equals(mission.getName(), missionName)
                                && Objects.equals(mission.level.getName(), levelName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 레벨/미션 정보가 없습니다."));
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public static List<String> findMissionNamesByLevel(Level level) { // 이거 순서대로 출력되려나
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.level == level)
                .map(Mission::getName)
                .collect(Collectors.toList());
    }
}
