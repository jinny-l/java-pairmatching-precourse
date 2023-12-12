package pairmatching.domain;

import java.util.Objects;

public class Crew {

    private final Course course;
    private final String name;
    private boolean isMatched;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
        this.isMatched = false;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public boolean getIsMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return course == crew.course && Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, name);
    }
}
