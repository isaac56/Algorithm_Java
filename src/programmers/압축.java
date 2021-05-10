package programmers;

import java.util.*;

public class 압축 {
    int nextDictNumber;

    public int[] solution(String msg) {
        nextDictNumber = 1;
        Map<String, Integer> map = new HashMap<>();

        while (nextDictNumber < 27) {
            String value = String.valueOf((char) ('A' + nextDictNumber - 1));
            map.put(value, nextDictNumber);
            nextDictNumber++;
        }

        List<Integer> answer = new ArrayList<>();

        while (msg.length() > 0) {
            msg = zip(msg, map, answer);
        }

        return answer.stream().mapToInt(x -> x.intValue()).toArray();
    }

    public String zip(String msg, Map<String, Integer> map, List<Integer> answer) {
        int end = 1;
        while (map.containsKey(msg.substring(0, end))) {
            if (end == msg.length()) {
                answer.add(map.get(msg));
                return "";
            }
            end++;
        }
        answer.add(map.get(msg.substring(0, end - 1)));
        map.put(msg.substring(0, end), nextDictNumber);
        nextDictNumber++;

        return msg.substring(end - 1);
    }
}
