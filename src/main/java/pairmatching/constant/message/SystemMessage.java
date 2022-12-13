package pairmatching.constant.message;

import pairmatching.constant.command.ReMatchCommand;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.repository.MissionsRepository;

public enum SystemMessage {

    INPUT_COMMAND("기능을 선택하세요."),
    INPUT_INFORMATION("과정, 레벨, 미션을 선택하세요."),
    INPUT_INFORMATION_EXAMPLE("ex) " + String.join(", ",
            Course.values()[0].getName(),
            Level.LEVEL1.getText(),
            MissionsRepository.missionsOf(Level.LEVEL1).get(0))),
    INPUT_REMATCH_COMMAND("매칭 정보가 있습니다. 다시 매칭하시겠습니까?"),
    INPUT_REMATCH_COMMAND_EXAMPLE(String.join(" | ", ReMatchCommand.YES.getText(), ReMatchCommand.NO.getText())),
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
