package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.MatchingInfo;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController implements Controller {

    private final MatchingService matchingService = new MatchingService();

    @Override
    public void run() {
        OutputView.printCourseAndMission(
                Course.values(),
                matchingService.findMissions()
        );

        MatchingInfo matchingInfo = readMatchingInfo();
    }

    private MatchingInfo readMatchingInfo() {
        try {
            return InputView.readMatchingInfo();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            return readMatchingInfo();
        }
    }

}
