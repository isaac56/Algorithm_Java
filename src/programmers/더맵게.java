package programmers;
import java.util.*;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int score : scoville) {
            pq.add(score);
        }
        while(pq.size() > 1 && pq.element() < K) {
            int s1 = pq.remove();
            int s2 = pq.remove();
            pq.add(s1 + s2*2);
            answer++;
        }
        if(pq.element() < K) answer = -1;

        return answer;
    }
}


