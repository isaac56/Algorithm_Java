package programmers;
import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] endDate = new int[progresses.length];

        for(int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            endDate[i] = left%speeds[i] > 0 ? left/speeds[i] + 1 : left/speeds[i];
        }
        Queue<Integer> que = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < endDate.length; i++) {
            if(!que.isEmpty() && endDate[que.element()] < endDate[i]){
                answerList.add(que.size());
                que.clear();
            }
            que.add(i);
        }
        if(!que.isEmpty()) {
            answerList.add(que.size());
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
