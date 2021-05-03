package programmers;

import java.util.HashMap;
import java.util.Map;

public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Map<String, Integer> m1 = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.charAt(i) < 'A' || 'Z' < str1.charAt(i) ||
                    str1.charAt(i + 1) < 'A' || 'Z' < str1.charAt(i + 1)) {
                continue;
            }
            String e = str1.substring(i, i + 2);
            int cnt = m1.getOrDefault(e, 0);
            m1.put(e, cnt + 1);
        }

        Map<String, Integer> m2 = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.charAt(i) < 'A' || 'Z' < str2.charAt(i) ||
                    str2.charAt(i + 1) < 'A' || 'Z' < str2.charAt(i + 1)) {
                continue;
            }
            String e = str2.substring(i, i + 2);
            int cnt = m2.getOrDefault(e, 0);
            m2.put(e, cnt + 1);
        }

        if (m1.size() == 0 && m2.size() == 0) {
            return 65536;
        }

        float a = 0;
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            if (m2.containsKey(key)) {
                int count2 = m2.get(key);
                a += count < count2 ? count : count2;
            }
        }

        float b = 0;
        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            if (m2.containsKey(key)) {
                int count2 = m2.get(key);
                b += count < count2 ? count2 : count;
            } else {
                b += count;
            }
        }
        for (Map.Entry<String, Integer> entry : m2.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            if (!m1.containsKey(key)) {
                b += count;
            }
        }

        return (int) ((float) (a / b) * 65536);
    }
}
