package pairmatching.constant.command;

import java.util.stream.Stream;
import pairmatching.constant.message.ErrorMessage;

public enum MainCommand {

    PAIR_MATCHING("페어 매칭", "1"),
    PAIR_SEARCHING("페어 조회", "2"),
    RESET("페어 초기화", "3"),
    QUIT("종료", "Q");

    private static final String FIELD_DELIMITER = ". ";

    private final String text;
    private final String command;

    MainCommand(String text, String command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public String getCommand() {
        return command;
    }

    public static MainCommand from(String input) {
        return Stream.of(values())
                .filter(command -> command.command.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.toString()));
    }

    @Override
    public String toString() {
        return command
                + FIELD_DELIMITER
                + text;
    }

}
