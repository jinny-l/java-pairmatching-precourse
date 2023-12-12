package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.util.FileReader;

public class CrewRepository {

    private static final String BACKEND_DATA_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_DATA_PATH = "src/main/resources/frontend-crew.md";
    private static final List<Crew> CREWS = new ArrayList<>();

    static {
        List<Crew> backendCrews = readCrewsFromFile(Course.BACKEND, BACKEND_DATA_PATH);
        List<Crew> frontendCrews = readCrewsFromFile(Course.FRONTEND, FRONTEND_DATA_PATH);

        CREWS.addAll(backendCrews);
        CREWS.addAll(frontendCrews);
    }

    private static List<Crew> readCrewsFromFile(Course course, String filePath) {
        return FileReader.read(filePath).stream()
                .map(name -> new Crew(course, name))
                .toList();
    }

    public List<String> findCrewNamesByCourse(Course course) {
        return CREWS.stream()
                .filter(crew -> crew.getCourse() == course)
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public Crew findByName(String name) {
        return CREWS.stream()
                .filter(crew -> Objects.equals(crew.getName(), name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("내부 오류"));
    }

    public int countByCourse(Course course) {
        return (int) CREWS.stream()
                .filter(crew -> crew.getCourse() == course)
                .count();
    }

    public Crew findUnMatched() {
        return CREWS.stream()
                .filter(crew -> !crew.getIsMatched())
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("내부 오류"));

    }

    public boolean allMatchedByCourse(Course course) {
        return CREWS.stream()
                .filter(crew -> crew.getCourse() == course)
                .allMatch(crew -> crew.getIsMatched() == true);
    }
}
