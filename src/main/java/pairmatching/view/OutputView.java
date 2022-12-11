package pairmatching.view;

import pairmatching.constant.Command;

public class OutputView {

    public static void printCommand() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Command.values().length; i++) {
            stringBuilder.append(Command.values()[i].toString());
        }
        System.out.print(stringBuilder);
    }

}
