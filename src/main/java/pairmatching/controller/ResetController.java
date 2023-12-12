package pairmatching.controller;

import pairmatching.service.MatchingService;

public class ResetController implements Controller {

    private final MatchingService matchingService = new MatchingService();

    @Override
    public void run() {
        matchingService.resetPair();
        System.out.println();
        System.out.println("초기화 되었습니다.");
        System.out.println();
    }
}
