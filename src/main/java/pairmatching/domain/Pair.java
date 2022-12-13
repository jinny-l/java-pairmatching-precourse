package pairmatching.domain;

import java.util.List;

public class Pair {

    private final Level level;
    private final String mission;
    private final List<List<String>> pairedCrews;

    public Pair(Level level, String mission, List<List<String>> pairedCrews) {
        this.level = level;
        this.mission = mission;
        this.pairedCrews = pairedCrews;
    }

    public Level level() {
        return level;
    }

    public String mission() {
        return mission;
    }

    public List<List<String>> crews() {
        return pairedCrews;
    }

    public boolean isPaired(List<String> crews) {
        for (List<String> pairedCrew : pairedCrews) {
            if (pairedCrews.contains(crews)) {
                return true;
            }
        }
        return false;
    }

}
