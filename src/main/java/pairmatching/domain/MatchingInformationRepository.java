package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchingInformationRepository {

    private static List<List<String>> matchingInformations = new ArrayList<>();

    public static void add(List<String> matchingInformation) {
        matchingInformations.add(matchingInformation);
    }

}
