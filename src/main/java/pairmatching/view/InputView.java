package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.constant.Command;
import pairmatching.constant.message.ErrorMessage;
import pairmatching.constant.message.SystemMessage;

public class InputView {

    private static final String INFORMATION_DELIMITER = ", ";

    public static Command readCommand() {
        System.out.println(SystemMessage.INPUT_COMMAND);
        OutputView.printCommand();
        return Command.from(readLine());
    }

    public static List<String> readInformation() {
        System.out.println(SystemMessage.INPUT_INFORMATION);
        System.out.println(SystemMessage.INPUT_INFORMATION_EXAMPLE);
        return Stream.of(readLine().split("\\s*" + INFORMATION_DELIMITER + "\\s*"))
                .collect(Collectors.toList());
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
