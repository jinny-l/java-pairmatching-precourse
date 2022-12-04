package pairmatching.view;

import pairmatching.constant.information.Course;
import pairmatching.constant.information.Level;

public class OutputView {

    private static final String COURSE = "과정%s%s%n";
    private static final String COURSE_DELIMITER = " | ";
    private static final String MISSION = "미션%s%n%s%n";
    private static final String COLON = ": ";
    private static final String INFORMATION_DELIMITER = "############################################";
    private static final String OUTPUT_RESULT = "페어 매칭 결과입니다.%n%s%n";

    public static void printInformation() {
        printCourse();
        printMissions();
    }

    private static void printCourse() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Course.values().length; i++) {
            stringBuilder.append(Course.values()[i].getName());
            if (i == Course.values().length - 1) {
                break;
            }
            stringBuilder.append(COURSE_DELIMITER);
        }
        System.out.println(INFORMATION_DELIMITER);
        System.out.printf(COURSE, COLON, stringBuilder);
    }

    private static void printMissions() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Level.values().length; i++) {
            stringBuilder.append(Level.values()[i].toString())
                    .append("\n");
            if (i == Level.values().length - 1) {
                stringBuilder.append(INFORMATION_DELIMITER);
            }
        }
        System.out.printf(MISSION, COLON, stringBuilder);
    }

    public static void printResult(String matchingResult) {
        System.out.printf(OUTPUT_RESULT, matchingResult);
    }

}
