package programmers;

import java.util.*;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        HashMap<String, Integer> hm = new HashMap<>();
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (hm.containsKey(city)) {
                hm.put(city, i);
                answer += 1;
            } else {
                if (hm.size() >= cacheSize) {
                    int min = cities.length + 100;
                    String remove = null;
                    for (Map.Entry<String, Integer> e : hm.entrySet()) {
                        if (e.getValue() < min) {
                            min = e.getValue();
                            remove = e.getKey();
                        }
                    }
                    if (remove != null) {
                        hm.remove(remove);
                    }
                }
                hm.put(city, i);
                answer += 5;
            }
        }

        return answer;
    }
}
