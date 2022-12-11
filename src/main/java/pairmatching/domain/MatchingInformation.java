package pairmatching.domain;

import java.util.List;
import pairmatching.constant.information.Course;
import pairmatching.constant.information.Mission;

public class MatchingInformation {

    private Course course;
    private Mission level;
    private String mission;

    public MatchingInformation(List<String> matchingInformation) {
        course = Course.from(matchingInformation.get(0));
        level = Mission.levelFrom(matchingInformation.get(1));
        mission = Mission.missionFrom(level, matchingInformation.get(2));
    }

    public Course getCourse() {
        return course;
    }
}
