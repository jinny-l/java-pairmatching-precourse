package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.information.Course;
import pairmatching.domain.Crew;
import pairmatching.util.CrewFileReader;

public class CrewRepository {

    private static final String BACKEND = "src/main/resources/backend-crew.md";
    private static final String FRONTEND = "src/main/resources/frontend-crew.md";

    public static final List<Crew> crews = new ArrayList<>();

    static {
        setBackend();
        setFrontend();
    }

    private static void setBackend () {
        List<String> crewsName = CrewFileReader.read(BACKEND);
        for (String crewName : crewsName) {
            crews.add(new Crew(Course.BACK_END, crewName));
        }
    }

    private static void setFrontend() {
        List<String> crewsName = CrewFileReader.read(FRONTEND);
        for (String crewName : crewsName) {
            crews.add(new Crew(Course.FRONT_END, crewName));
        }
    }

    public static List<String> getNamesOf(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse().equals(course))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
