package pairmatching.controller;

import pairmatching.domain.Command;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    public void run() {
        Command command = readCommand();
    }

    private Command readCommand() {
        try {
            return InputView.readCommand();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readCommand();
        }
    }
}
