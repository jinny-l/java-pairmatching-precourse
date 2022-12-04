package pairmatching.domain;

import java.util.List;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.information.Course;
import pairmatching.constant.information.Level;

public class MatchingInformation {

    private static final int SIZE = 3;

    private final List<String> information;

    public MatchingInformation(List<String> information) {
        validateSize(information);
        Course.validate(information.get(0));
        Level.validate(information.get(1), information.get(2));
        MatchingInformationRepository.add(information);
        this.information = information;
    }

    private void validateSize(List<String> information) {
        if (information.size() != SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INFORMATION.toString());
        }
    }

    public String getCourse() {
        return information.get(0);
    }

    public String getLevel() {
        return information.get(1);
    }

    public String getMission() {
        return information.get(2);
    }

}
