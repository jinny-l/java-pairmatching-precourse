package pairmatching.Controller;

import pairmatching.service.PairViewService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairViewController {

    private final PairViewService pairViewService;

    public PairViewController() {
        pairViewService = new PairViewService();
    }

    public void run() {
        int informationIndex = readInformationIndex();
        printMatchingResult(informationIndex);
    }

    private int readInformationIndex() {
        try {
            return pairViewService.findMatchingInformationIndex(InputView.readInformation());
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
            return readInformationIndex();
        }
    }

    private void printMatchingResult(int index) {
        OutputView.printMatchingResult(pairViewService.findPairInformation(index));
    }

}
