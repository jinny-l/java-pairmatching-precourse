package pairmatching.Controller;

import pairmatching.service.ResetService;
import pairmatching.view.OutputView;

public class ResetController {

    private final ResetService resetService;

    public ResetController() {
        resetService = new ResetService();
    }

    public void run() {
        reset();
    }

    private void reset() {
        resetService.reset();
        OutputView.printReset();
    }

}
