package pairmatching.domain;

import java.util.List;
import pairmatching.util.CrewReader;

public class FrontEndRepository {

    private static final String file =
            "/Users/jinny-l/Desktop/Jinny/Java/Woowa-Precourse"
                    + "/java-pairmatching-precourse/src/main/resources/frontend-crew.md";
    private static final List<String> crews = CrewReader.read(file);

    public static List<String> getCrews() {
        return crews;
    }

}
