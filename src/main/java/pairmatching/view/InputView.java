package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.constant.Command;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.information.Course;
import pairmatching.constant.information.Level;

public class InputView {

    private static final String INPUT_COMMAND = "기능을 선택하세요.";
    private static final String INPUT_INFORMATION = "과정, 레벨, 미션을 선택하세요.%nex) %s%n";
    private static final String INFORMATION_DELIMITER = ", ";

    public static String readCommand() {
        System.out.println(INPUT_COMMAND);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Command.values().length; i++) {
            stringBuilder.append(Command.values()[i].toString());
        }
        System.out.println(stringBuilder);
        return Command.from(readLine());
    }

    public static List<String> readMatchingInformation() {
        printExample();
        String input = readLine();
        return Stream.of(input.split("\\s*" + INFORMATION_DELIMITER + "\\s*"))
                .collect(Collectors.toList());
    }

    private static void printExample() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Course.values()[0].getName())
                .append(INFORMATION_DELIMITER)
                .append(Level.values()[0].getName())
                .append(INFORMATION_DELIMITER)
                .append(Level.values()[0].getMissions().get(0));
        System.out.printf(INPUT_INFORMATION, stringBuilder);
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
