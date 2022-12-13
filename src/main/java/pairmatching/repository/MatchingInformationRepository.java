package pairmatching.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.domain.MatchingInformation;

public class MatchingInformationRepository {

    private static final List<MatchingInformation> matchingInformations = new ArrayList<>();

    public static List<MatchingInformation> matchingInformations() {
        return Collections.unmodifiableList(matchingInformations);
    }

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

    public static MatchingInformation findInformationOf(MatchingInformation information) {
        return matchingInformations.stream()
                .filter(matchingInformation -> matchingInformation.getCourse().equals(information.getCourse()))
                .filter(matchingInformation -> matchingInformation.getLevel().equals(information.getLevel()))
                .filter(matchingInformation -> matchingInformation.getMission().equals(information.getMission()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("매칭 이력이 없습니다."));
    }

    public static int indexOf(MatchingInformation matchingInformation) {
        return matchingInformations.indexOf(matchingInformation);
    }

    public static void removeOf(MatchingInformation matchingInformation) {
        matchingInformations.remove(matchingInformation);
    }

    public static void reset() {
        matchingInformations.clear();
    }
}
