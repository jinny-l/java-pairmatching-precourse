package pairmatching.domain;

import java.util.List;
import pairmatching.constant.message.ErrorMessage;
import pairmatching.repository.MissionsRepository;

public class MatchingInformation {

    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final Course course;
    private final Level level;
    private final String mission;

    public MatchingInformation(List<String> matchingInformation) {
        validateSize(matchingInformation);
        course = Course.from(matchingInformation.get(COURSE_INDEX));
        level = Level.from(matchingInformation.get(LEVEL_INDEX));
        mission = validateMission(level, matchingInformation.get(MISSION_INDEX));
    }

    public Course getCourse() {
        return course;
    }

    private void validateSize(List<String> matchingInformation) {
        if (matchingInformation.size() != MatchingInformation.class.getDeclaredFields().length) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INFORMATION.toString());
        }
    }

    private String validateMission(Level level, String mission) {
        if (!MissionsRepository.hasMission(level, mission)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MISSION.toString());
        }
        return mission;
    }

}
