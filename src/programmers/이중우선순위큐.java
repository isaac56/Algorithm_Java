package programmers;

import java.util.*;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for(String cmd : operations) {
            String[] temp = cmd.split(" ");
            if(temp[0].equals("I")){
                Integer v = Integer.parseInt(temp[1]);
                maxQ.add(v);
                minQ.add(v);
            }
            else if(temp[0].equals("D") && temp[1].equals("1")){
                if(!maxQ.isEmpty()) {
                    int v = maxQ.remove();
                    minQ.remove(v);
                }
            }
            else {
                if(!minQ.isEmpty()) {
                    int v = minQ.remove();
                    maxQ.remove(v);
                }
            }
        }

        int[] answer = new int[2];
        if(maxQ.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = maxQ.element();
            answer[1] = minQ.element();
        }


        return answer;
    }
}
