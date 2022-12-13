package pairmatching.domain;

import java.util.List;

public class Missions {

    private static final String DASH = "- ";
    private static final String LEVEL_DELIMITER = ": ";
    private static final String MISSION_DELIMITER = " | ";

    private final Level level;
    private final List<String> missions;

    public Missions(Level level, List<String> missions) {
        this.level = level;
        this.missions = missions;
    }

    public Level getLevel() {
        return level;
    }

    public List<String> getMissions() {
        return missions;
    }

    public boolean contains(String mission) {
        return missions.contains(mission);
    }

    @Override
    public String toString() {
        return DASH
                + level
                + LEVEL_DELIMITER
                + String.join(MISSION_DELIMITER, missions)
                + "\n";
    }

}
