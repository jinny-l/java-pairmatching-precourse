package pairmatching.view;

import java.util.List;
import java.util.stream.Stream;
import pairmatching.constant.command.MainCommand;
import pairmatching.constant.message.SystemMessage;
import pairmatching.domain.Course;
import pairmatching.domain.Missions;
import pairmatching.repository.MissionsRepository;

public class OutputView {

    private static final String DASH = "  - ";
    private static final String COLON = ": ";
    private static final String PAIR_DELIMITER = " : ";
    private static final String MISSION_DELIMITER = " | ";
    private static final String COURSE_DELIMITER = " | ";
    private static final String INFORMATION_DELIMITER = "############################################";

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printCommand() {
        Stream.of(MainCommand.values())
                .forEach(mainCommand -> System.out.println(mainCommand.toString()));
    }

    public static void printInformation() {
        System.out.println();
        System.out.println(INFORMATION_DELIMITER);
        printCourse();
        printMission();
        System.out.println(INFORMATION_DELIMITER);
    }

    private static void printCourse() {
        System.out.print(SystemMessage.OUTPUT_COURSE);
        System.out.println(String.join(COURSE_DELIMITER, Course.getAllName()));
    }

    private static void printMission() {
        System.out.println(SystemMessage.OUTPUT_MISSION);
        System.out.print(convertMissionsToView());
    }

    private static String convertMissionsToView () {
        StringBuilder stringBuilder = new StringBuilder();
        List<Missions> missions = MissionsRepository.missions();
        for (Missions mission : missions) {
            stringBuilder.append(DASH)
                    .append(mission.getLevel().getText())
                    .append(COLON)
                    .append(String.join(MISSION_DELIMITER, mission.getMissions()))
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    public static void printMatchingResult(List<List<String>> pairs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> pair : pairs) {
            stringBuilder.append(String.join(PAIR_DELIMITER, pair))
                    .append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void printReset() {
        System.out.println();
        System.out.println(SystemMessage.OUTPUT_RESET);
        System.out.println();
    }

}
