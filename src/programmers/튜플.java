package programmers;

import java.util.*;

public class 튜플 {
    public int[] solution(String s) {
        String[] tupleStrs = s.substring(2, s.length() - 2).split("\\},\\{");
        List<Set<Integer>> tuples = new ArrayList<>();
        for (String tupleStr : tupleStrs) {
            tuples.add(getSet(tupleStr));
        }
        Collections.sort(tuples, (a, b) -> {
            if (a.size() < b.size()) {
                return -1;
            } else if (a.size() > b.size()) {
                return 1;
            } else {
                return 0;
            }
        });

        int[] ret = new int[tuples.size()];
        for (int i = tuples.size() - 1; i >= 1; i--) {
            Set<Integer> t1 = tuples.get(i);
            Set<Integer> t2 = tuples.get(i - 1);
            t1.removeAll(t2);
        }
        for (int i = 0; i < tuples.size(); i++) {
            ret[i] = tuples.get(i).stream().mapToInt(x -> x.intValue()).findFirst().getAsInt();
        }

        return ret;
    }

    public Set<Integer> getSet(String s) {
        String[] arr = s.split(",");
        Set<Integer> ret = new HashSet<>();
        for (String e : arr) {
            ret.add(Integer.valueOf(e));
        }
        return ret;
    }
}
