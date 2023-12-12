package pairmatching.controller;

import pairmatching.domain.Command;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController implements Controller {

    @Override
    public void run() {
        while (true) {
            OutputView.printCommand(Command.values());
            Command command = readCommand();

            if (command == Command.EXIT) {
                break;
            }

            if (command == Command.MATCHING) {
                Controller controller = new MatchingController();
                controller.run();
            }

            if (command == Command.VIEW_PAIR) {
                Controller controller = new ViewController();
                controller.run();
            }

            if (command == Command.RESET_PAIR) {
                Controller controller = new ResetController();
                controller.run();
            }
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
