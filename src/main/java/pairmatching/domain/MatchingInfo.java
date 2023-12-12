package pairmatching.domain;

public class MatchingInfo {

    private final Course course;
    private final Mission mission;

    private MatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public static MatchingInfo from(String courseName, String levelName, String missionName) {
        return new MatchingInfo(
                Course.from(courseName),
                Mission.from(missionName, levelName)
        );
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
