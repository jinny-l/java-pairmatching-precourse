package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.MatchingInformation;

public class MatchingInformationRepository {

    private static final List<MatchingInformation> matchingInformations = new ArrayList<>();

    public static void add(MatchingInformation matchingInformation) {
        matchingInformations.add(matchingInformation);
    }

    // TODO: 객체 필드 동일 여부를 비교할 수 있는 더 좋은 방법이 있을지??
    public static boolean contains(MatchingInformation matchingInformation) {
        for (MatchingInformation information : matchingInformations) {
            if (information.getCourse().equals(matchingInformation.getCourse())
                    && information.getLevel().equals(matchingInformation.getLevel())
                    && information.getMission().equals(matchingInformation.getMission()))
                return true;
        }
        return false;
    }

    public static int indexOf(MatchingInformation matchingInformation) {
        return matchingInformations.indexOf(matchingInformation);
    }

    public static void reset() {
        matchingInformations.clear();
    }
}
