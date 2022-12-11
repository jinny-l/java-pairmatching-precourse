package pairmatching.constant.message;

import pairmatching.constant.information.Course;
import pairmatching.constant.information.Mission;

public enum SystemMessage {

    INPUT_COMMAND("기능을 선택하세요."),
    INPUT_INFORMATION("과정, 레벨, 미션을 선택하세요."),
    INPUT_INFORMATION_EXAMPLE("ex) " + String.join(",",
            Course.values()[0].getName(),
            Mission.values()[0].getLevel(),
            Mission.values()[0].getMissions().get(0))),
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
