package pairmatching.controller;

import pairmatching.domain.Command;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController implements Controller {

    @Override
    public void run() {
        OutputView.printCommand(Command.values());
        Command command = readCommand();

        if (command == Command.MATCHING) {
            Controller controller = new MatchingController();
            controller.run();
        }
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
