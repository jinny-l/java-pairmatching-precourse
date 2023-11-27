package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.domain.Command;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class OutputView {

    private OutputView() {
    }

    public static void printError(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public static void printCommand(Command[] commands) {
        System.out.println("기능을 선택하세요.");

        String result = Arrays.stream(commands)
                .map(command -> String.format("%s. %s", command.getCode(), command.getName()))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(result);
    }

    public static void printCourseAndMission(Course[] courses, Map<Level, List<String>> missions) {
        String separator = "#".repeat(45);
        String format = "%n%s%n%s%n%s%s%n";

        System.out.printf(
                format,
                separator,
                formatCourses(courses),
                formatMissions(missions),
                separator
        );
    }

    private static String formatCourses(Course[] courses) {
        String format = "과정: %s";

        String result = Arrays.stream(courses) // 변수명 마음에 안듦
                .map(Course::getName)
                .collect(Collectors.joining(" | "));

        return String.format(format, result);
    }

    private static String formatMissions(Map<Level, List<String>> missions) {
        String format = "미션:%n%s%n";

        String result = missions.entrySet().stream()
                .map(entry -> String.format(
                        "  - %s: %s",
                        entry.getKey().getName(),
                        String.join(" | ", entry.getValue()))
                )
                .collect(Collectors.joining(System.lineSeparator()));

        return String.format(format, result);
    }
}
