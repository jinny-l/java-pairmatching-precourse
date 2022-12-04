package pairmatching.constant;

public enum Command {

    PAIR_MATCHING("페어 매칭", "1"),
    PAIR_SEARCHING("페어 조회", "2"),
    RESET("페어 초기화", "3"),
    QUIT("종료", "Q");

    private static final String FIELD_DELIMITER = ". ";

    private final String text;
    private final String command;

    Command(String text, String command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public String getCommand() {
        return command;
    }

    public static String from(String input) {
        validate(input);
        return input;
    }

    private static void validate(String input) {
        if (!input.equals(PAIR_MATCHING.command) && !input.equals(PAIR_SEARCHING.command)
                && !input.equals(RESET.command) && !input.equals(QUIT.command)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COMMAND.toString());
        }
    }

    @Override
    public String toString() {
        return getCommand()
                + FIELD_DELIMITER
                + getText()
                + "\n";
    }

}
