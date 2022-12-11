package pairmatching.domain;

import java.util.List;
import pairmatching.constant.information.Course;
import pairmatching.constant.information.Level;
import pairmatching.constant.message.ErrorMessage;
import pairmatching.repository.MissionsRepository;

public class MatchingInformation {

    private final Course course;
    private final Level level;
    private final String mission;

    public MatchingInformation(List<String> matchingInformation) {
        validateSize(matchingInformation);
        course = Course.from(matchingInformation.get(0));
        level = Level.from(matchingInformation.get(1));
        validateMission(level, matchingInformation.get(2));
        mission = matchingInformation.get(2);
    }

    public Course getCourse() {
        return course;
    }

    private void validateSize(List<String> matchingInformation) {
        if (matchingInformation.size() != MatchingInformation.class.getDeclaredFields().length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INFORMATION.toString());
        }
    }

    private void validateMission(Level level, String mission) {
        if (!MissionsRepository.hasMission(level, mission)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MISSION.toString());
        }
    }

}
