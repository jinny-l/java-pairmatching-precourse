package pairmatching.constant.command;

import java.util.stream.Stream;
import pairmatching.constant.message.ErrorMessage;

public enum ReMatchCommand {

    YES("네"),
    NO("아니오");

    private final String text;

    ReMatchCommand(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static ReMatchCommand from(String input) {
        return Stream.of(values())
                .filter(command -> command.text.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.toString()));
    }

}
