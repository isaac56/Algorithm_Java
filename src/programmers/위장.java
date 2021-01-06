package programmers;
import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1],0) + 1);
        }

        int answer = 1;
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            answer *= entry.getValue() + 1;
        }

        return answer-1;
    }
}
