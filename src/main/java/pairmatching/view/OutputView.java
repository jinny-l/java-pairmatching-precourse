package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import pairmatching.domain.Command;

public class OutputView {

    private OutputView() {
    }

    public static void printError(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public static void printCommand(Command[] commands) {
        System.out.println("기능을 선택하세요.");

        String result = Arrays.stream(commands)
                .map(command -> String.format("%s. %s", command.getCode(), command.getName()))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(result);
    }
}
