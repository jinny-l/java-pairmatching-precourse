package pairmatching.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pairmatching.constant.information.Level;
import pairmatching.domain.Missions;

public class MissionsRepository {

    private static final List<Missions> missions = new ArrayList<>();

    static {
        missions.add(new Missions(Level.LEVEL1, Arrays.asList("자동차경주", "로또", "숫자야구게임")));
        missions.add(new Missions(Level.LEVEL2, Arrays.asList("장바구니", "결제", "지하철노선도")));
        missions.add(new Missions(Level.LEVEL3, Collections.emptyList()));
        missions.add(new Missions(Level.LEVEL4, Arrays.asList("성능개선", "배포")));
        missions.add(new Missions(Level.LEVEL5, Collections.emptyList()));
    }

    public static List<String> missionsOf(Level level) {
        return missions.stream()
                .filter(m -> m.getLevel().equals(level))
                .findAny()
                .get()
                .getMissions();
    }

}
