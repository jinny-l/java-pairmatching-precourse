package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchingServiceRepository {

    private static List<List<String>> matchingService = new ArrayList<>();

    public static void add(List<String> matchingResult) {
        matchingService.add(matchingResult);
    }

}
