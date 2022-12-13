package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Pair;

public class PairRepository {

    private static final List<Pair> pairs = new ArrayList<>();

    public static void add(Pair pair) {
        pairs.add(pair);
    }

    public static List<List<String>> findNamesByIndex(int index) {
        Pair pair = pairs.get(index);
        return pair.crews();
    }

    public static void remove(int index) {
        pairs.remove(index);
    }

    public static void reset() {
        pairs.clear();
    }

}
