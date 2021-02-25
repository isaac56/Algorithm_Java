package basic;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public List<int[]> getCombination(int n, int r) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == r) {
                int[] add = new int[n];
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        add[j] = 1;
                    }
                }
                list.add(add);
            }
        }
        return list;
    }
}
