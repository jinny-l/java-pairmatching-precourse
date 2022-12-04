package pairmatching.domain;

public class Crew {

    private final String course;
    private final String name;

    public Crew(String course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

}
