package pairmatching.view;

import java.util.stream.Stream;
import pairmatching.constant.Command;
import pairmatching.constant.information.Course;
import pairmatching.constant.information.Mission;
import pairmatching.constant.message.SystemMessage;

public class OutputView {

    private static final String COURSE_DELIMITER = " | ";
    private static final String INFORMATION_DELIMITER = "############################################";

    public static void printCommand() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Command.values().length; i++) {
            stringBuilder.append(Command.values()[i].toString());
        }
        System.out.print(stringBuilder);
    }

    public static void printInformation() {
        System.out.println(INFORMATION_DELIMITER);
        printCourse();
        printMission();
        System.out.print(INFORMATION_DELIMITER);
    }

    private static void printCourse() {
        System.out.print(SystemMessage.OUTPUT_COURSE);
        System.out.println(String.join(COURSE_DELIMITER, Course.getAllName()));
    }

    private static void printMission() {
        System.out.println(SystemMessage.OUTPUT_MISSION);
        Stream.of(Mission.values())
                .forEach(mission -> System.out.print((mission.toString())));
    }

}
