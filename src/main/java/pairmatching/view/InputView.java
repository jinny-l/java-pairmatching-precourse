package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Command;
import pairmatching.domain.MatchingInfo;

public class InputView {

    private InputView() {
    }

    public static Command readCommand() {
        return Command.from(readLine());
    }

    public static MatchingInfo readMatchingInfo() {
        System.out.printf("과정, 레벨, 미션을 선택하세요.%nex) 백엔드, 레벨1, 자동차경주%n");

        String[] input = readLine().split(", "); // TODO 유효성 검증

        return MatchingInfo.from(
                input[0],
                input[1],
                input[2]
        );
    }

    private static String readLine() {
        String input = Console.readLine().strip();
        validateHasInput(input);
        return input;
    }

    private static void validateHasInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
    }
}
