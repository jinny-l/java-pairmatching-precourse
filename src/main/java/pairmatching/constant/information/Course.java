package pairmatching.constant.information;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.constant.message.ErrorMessage;

public enum Course {

    BACK_END("백엔드"),
    FRONT_END("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> getAllName() {
        return Stream.of(Course.values())
                .map(Course::getName)
                .collect(Collectors.toList());
    }

    public static Course from(String input) {
        return Stream.of(Course.values())
                .filter(course -> course.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COURSE.toString()));
    }

}
