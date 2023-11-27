package pairmatching.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Command {

    MATCHING("1", "페어 매칭"),
    VIEW_PAIR("2", "페어 조회"),
    RESET_PAIR("3", "페어 초기화"),
    EXIT("Q", "종료");

    private final String code;
    private final String name;

    Command(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Command from(String code) {
        return Arrays.stream(Command.values())
                .filter(command -> Objects.equals(command.code, code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 기능 명령어 입니다."));
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
