package pairmatching.domain;

import java.util.List;

public class Pair {

    private final Mission mission;
    private final List<Crew> crews;

    public Pair(Mission mission, List<Crew> crews) {
        this.mission = mission;
        this.crews = crews;
    }

    public Mission getMission() {
        return mission;
    }

    public Course getCourse() {
        return crews.get(0).getCourse();
    }

    public List<String> getCrewNames() {
        return crews.stream()
                .map(Crew::getName)
                .toList();
    }

    public void setMatched(boolean matched) {
        crews.forEach(crew -> crew.setMatched(true));
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    public boolean hasCrew(List<Crew> crews) {
        return crews.stream()
                .anyMatch(this.crews::contains);
    }


}
