package programmers;
import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        for(String name : completion) {
            hash.put(name, hash.getOrDefault(name, 0) + 1);
        }

        String answer = "";
        for(String name : participant){
            if(!hash.containsKey(name) || hash.get(name) == 0) {
                answer = name;
                break;
            }

            hash.put(name, hash.get(name) - 1);
        }
        return answer;
    }
}
