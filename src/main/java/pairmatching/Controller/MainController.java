package pairmatching.Controller;

import pairmatching.constant.command.MainCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final MatchingController matchingController;
    private final PairViewController pairViewController;
    private final ResetController resetController;

    public MainController() {
        matchingController = new MatchingController();
        pairViewController = new PairViewController();
        resetController = new ResetController();
    }

    public void run() {
        MainCommand command = readMainCommand();
        if (command.equals(MainCommand.QUIT)) {
            return;
        }
        if (command.equals(MainCommand.PAIR_MATCHING)) {
            matchingController.run();
        }
        if (command.equals(MainCommand.PAIR_VIEW)) {
            pairViewController.run();
        }
        if (command.equals(MainCommand.RESET)) {
            resetController.run();
        }
        run();
    }

    private MainCommand readMainCommand() {
        try {
            return InputView.readCommand();
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readMainCommand();
        }
    }

}
