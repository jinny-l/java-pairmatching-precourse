package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Command;
import pairmatching.constant.message.ErrorMessage;
import pairmatching.constant.message.SystemMessage;

public class InputView {

    public static Command readCommand() {
        System.out.println(SystemMessage.INPUT_COMMAND);
        OutputView.printCommand();
        return Command.from(readLine());
    }

    private static String readLine() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

    private static void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.toString());
        }
    }

}
