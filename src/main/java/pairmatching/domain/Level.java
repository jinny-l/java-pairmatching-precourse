package pairmatching.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Level {

    ONE("레벨1"),
    TWO("레벨2"),
    THREE("레벨3"),
    FOUR("레벨4"),
    FIVE("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static Level from(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> Objects.equals(level.getName(), name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 레벨 정보가 없습니다."));
    }

    public String getName() {
        return name;
    }
}
