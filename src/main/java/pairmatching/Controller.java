package pairmatching;

import java.util.List;
import pairmatching.constant.Command;
import pairmatching.domain.Crews;
import pairmatching.domain.MatchingInformation;
import pairmatching.domain.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    private Crews crews;
    private MatchingService matchingService;
    private MatchingInformation matchingInformation;
    private String command;;

    public void run() {
        do {
            readCommand();
            OutputView.printInformation();
            readInformation();
            printMatchingResult();
        } while (!command.equals(Command.QUIT.getCommand()));
    }

    private void initialize() {
        crews = new Crews();
    }

    private void readCommand() {
        try {
            command = InputView.readCommand();
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            readCommand();
        }
    }

    private void readInformation() {
        try {
            List<String> input = InputView.readMatchingInformation();
            matchingInformation = new MatchingInformation(input);
            matchingService = new MatchingService(input);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            readInformation();
        }
    }

    private void isMatchedBefore() {
    }

    private void printMatchingResult() {
        OutputView.printResult(matchingService.toString());
    }

}
