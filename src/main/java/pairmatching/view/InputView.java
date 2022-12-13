package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.constant.command.MainCommand;
import pairmatching.constant.command.ReMatchCommand;
import pairmatching.constant.message.ErrorMessage;
import pairmatching.constant.message.SystemMessage;

public class InputView {

    private static final String INFORMATION_DELIMITER = ", ";

    public static MainCommand readCommand() {
        System.out.println(SystemMessage.INPUT_COMMAND);
        OutputView.printCommand();
        return MainCommand.from(readLine());
    }

    public static List<String> readInformation() {
        System.out.println(SystemMessage.INPUT_INFORMATION);
        System.out.println(SystemMessage.INPUT_INFORMATION_EXAMPLE);
        return Stream.of(readLine().split("\\s*" + INFORMATION_DELIMITER + "\\s*"))
                .collect(Collectors.toList());
    }

    public static ReMatchCommand readRematchCommand() {
        System.out.println(SystemMessage.INPUT_REMATCH_COMMAND);
        System.out.println(SystemMessage.INPUT_REMATCH_COMMAND_EXAMPLE);
        return ReMatchCommand.from(readLine());
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
