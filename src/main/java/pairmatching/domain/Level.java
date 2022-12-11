package pairmatching.domain;

import java.util.stream.Stream;
import pairmatching.constant.message.ErrorMessage;

public enum Level {

    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String text;

    Level(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Level from(String input) {
        return Stream.of(Level.values())
                .filter(level -> level.text.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LEVEL.toString()));
    }

}
