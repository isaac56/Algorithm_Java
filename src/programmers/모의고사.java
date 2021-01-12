package programmers;
import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] solve1 = {1,2,3,4,5};
        int[] solve2 = {2,1,2,3,2,4,2,5};
        int[] solve3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[4];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == solve1[i%solve1.length])
                score[1]++;
            if(answers[i] == solve2[i%solve2.length])
                score[2]++;
            if(answers[i] == solve3[i%solve3.length])
                score[3]++;
        }

        int max = 0;
        for(int i = 1; i <= 3; i++){
            if(score[i] > max)
                max = score[i];
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            if(max == score[i])
                list.add(i);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
