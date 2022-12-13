package pairmatching.Controller;

import pairmatching.constant.command.ReMatchCommand;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private MatchingService matchingService;

    public void run() {
        readInformation();
        if (matchingService.isMatched()) {
            rematchOrNot();
            return;
        }
        matching();
    }

    private void readInformation() {
        try {
            OutputView.printInformation();
            matchingService = new MatchingService(InputView.readInformation());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            readInformation();
        }
    }

    private void matching() {
        matchingService.shuffleAndMatch();
        OutputView.printMatchingResult(matchingService.matchingResult());
    }

    private void rematchOrNot() {
        ReMatchCommand reMatchCommand = readRematchCommand();
        if (reMatchCommand.equals(ReMatchCommand.NO)) {
            return;
        }
        if (reMatchCommand.equals(ReMatchCommand.YES)) {
            rematch();
        }
    }

    private ReMatchCommand readRematchCommand() {
        try {
            return InputView.readRematchCommand();
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readRematchCommand();
        }
    }

    private void rematch() {
        matchingService.rematch();
        OutputView.printMatchingResult(matchingService.matchingResult());
    }

}
