package pairmatching.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Course {

    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> Objects.equals(course.getName(), name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 과정 정보가 없습니다."));
    }

    public String getName() {
        return name;
    }
}
