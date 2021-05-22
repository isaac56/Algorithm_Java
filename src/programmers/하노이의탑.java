package programmers;

import java.util.*;

public class 하노이의탑 {
    public int[][] solution(int n) {
        Map<String, List<int[]>> memory = new HashMap<>();
        List<int[]> answerList = dp(1, 3, 2, n, memory);


        int[][] answer = new int[answerList.size()][];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public List<int[]> dp(int start, int end, int other, int number, Map<String, List<int[]>> memory) {
        String key = "" + start + end + number;
        List<int[]> answer = new ArrayList<>();

        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        if (number == 1) {
            answer.add(new int[]{start, end});
            return answer;
        }

        answer.addAll(dp(start, other, end, number - 1, memory));
        answer.add(new int[]{start, end});
        answer.addAll(dp(other, end, start, number - 1, memory));
        memory.put(key, answer);

        return answer;
    }
}
