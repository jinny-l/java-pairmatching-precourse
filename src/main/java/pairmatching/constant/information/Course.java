package pairmatching.constant.information;

import pairmatching.constant.Command;

public enum Course {

    BACK_END("백엔드"),
    FRONT_END("프론트엔드");

    private static final String NAME_DELIMITER = " | ";

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String from(String input) {
        validate(input);
        return input;
    }

    private static void validate(String input) {
        for (int i = 0; i < Course.values().length; i++) {
            if (!input.equals(Command.values()[i].name())) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Course.values().length; i++) {
            stringBuilder.append(Course.values()[i].name);
            if (Course.values()[i].ordinal() == Course.values().length - 1) {
                break;
            }
            stringBuilder.append(NAME_DELIMITER);
        }
        return stringBuilder.toString();
    }
}
