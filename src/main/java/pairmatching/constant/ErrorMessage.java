package pairmatching.constant;

public enum ErrorMessage {

    EMPTY_INPUT("입력 값이 없습니다."),
    INVALID_COMMAND("유효하지 않은 명령어를 입력했습니다."),
    INVALID_COURSE("유효하지 않은 과정을 입력했습니다."),
    INVALID_LEVEL("유효하지 않은 레벨을 입력했습니다."),
    INVALID_MISSION("유효하지 않은 미션을 입력했습니다."),
    INVALID_INFORMATION("정확하지 않은 정보를 입력했습니다.");

    private static final String ERROR = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }

}
