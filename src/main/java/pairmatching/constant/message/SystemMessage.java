package pairmatching.constant.message;

public enum SystemMessage {

    INPUT_COMMAND("기능을 선택하세요."),
    OUTPUT_COURSE("과정: "),
    OUTPUT_MISSION("미션: ");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
