package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.MatchingInfo;
import pairmatching.repository.PairRepository;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ViewController implements Controller {

    private final MatchingService matchingService = new MatchingService();
    private final PairRepository pairRepository = new PairRepository();

    @Override
    public void run() {
        OutputView.printCourseAndMission(
                Course.values(),
                matchingService.findMissions()
        );

        MatchingInfo matchingInfo = readMatchingInfo();
        boolean isExist = pairRepository.existsMatching(matchingInfo);

        if (!isExist) {
            System.out.println("[ERROR] 매칭 이력이 없습니다.");
            return;
        }

        OutputView.printPairs(matchingService.findPairsBy(matchingInfo));
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
