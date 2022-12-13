package pairmatching.domain;

import java.util.List;

public class Pair {

    private Level level;
    private final List<Crew> pairedCrews;

    public Pair(Level level, List<Crew> pairedCrews) {
        this.level = level;
        this.pairedCrews = pairedCrews;
    }

    public List<Crew> crews() {
        return pairedCrews;
    }

    public boolean isPaired(String name) {
        return pairedCrews.stream()
                .anyMatch(crew -> crew.getName().equals(name));
    }

}
