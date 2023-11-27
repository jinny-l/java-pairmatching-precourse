package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Command;

public class InputView {

    private InputView() {
    }

    public static Command readCommand() {
        return Command.from(readLine());
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
