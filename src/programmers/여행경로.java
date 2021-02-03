package programmers;
import java.util.*;

public class 여행경로 {
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (String[] a, String[] b)->{
            if(!a[0].equals(b[0]))
                return a[0].compareTo(b[0]);
            else if (!a[1].equals(b[1]))
                return a[1].compareTo(b[1]);
            else
                return 0;
        });
        Stack<String> answer = new Stack<>();
        answer.push("ICN");
        boolean[] used = new boolean[tickets.length];
        DFS(tickets, used, answer, 0);

        String[] ret = new String[answer.size()];
        for(int j = 0; j < answer.size();j++){
            ret[j] = answer.get(j);
        }
        return ret;
    }

    boolean DFS(String[][] tickets, boolean[] used, Stack<String> visit, int usedNum){
        if(usedNum == tickets.length)
            return true;

        for(int i = 0; i < tickets.length; i++) {
            if(used[i] == false && tickets[i][0].equals(visit.peek())){
                used[i] = true;
                visit.push(tickets[i][1]);
                if(DFS(tickets, used, visit, usedNum + 1))
                    return true;
                used[i] = false;
                visit.pop();
            }
        }
        return false;
    }
}
