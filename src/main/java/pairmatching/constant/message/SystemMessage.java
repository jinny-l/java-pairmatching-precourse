package pairmatching.constant.message;

public enum SystemMessage {

    INPUT_COMMAND("기능을 선택하세요.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
