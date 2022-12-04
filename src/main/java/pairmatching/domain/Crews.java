package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {

    private static List<Crew> crews = new ArrayList<>();

    public static void set() {
        setBackEnd();
        setFrontEnd();
    }

    private static void setBackEnd() {
        List<String> backEnd = BackEndRepository.getCrews();
        for (String crew : backEnd) {
            crews.add(new Crew("백엔드", crew));
        }
    }

    private static void setFrontEnd() {
        List<String> frontEnd = FrontEndRepository.getCrews();
        for (String crew : frontEnd) {
            crews.add(new Crew("프론트엔드", crew));
        }
    }

    public static List<String> getNamesOf(String course) {
        return crews.stream()
                .filter(crew -> crew.getCourse().equals(course))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    public static String getCourseOf(String name) {
        return crews.stream()
                .filter(crew -> crew.getName().equals(name))
                .findAny()
                .get()
                .getCourse();
    }
}
