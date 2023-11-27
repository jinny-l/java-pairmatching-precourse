package pairmatching.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MissionRepository {

    private static final Map<Level, List<String>> MISSIONS = new EnumMap<>(Level.class);

    static {
        MISSIONS.putAll(Arrays.stream(Level.values())
                .collect(Collectors.toMap(
                        level -> level,
                        Mission::findMissionNamesByLevel)
                )
        );
    }

    public Map<Level, List<String>> findAll() {
        return Collections.unmodifiableMap(MISSIONS);
    }
}
