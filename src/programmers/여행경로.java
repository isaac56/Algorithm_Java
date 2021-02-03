package programmers;
import java.util.*;

public class 여행경로 {
    //Iterative 하게 DFS 풀이
    class State{
        List<String> visit;
        boolean[] used;
        int usedNum;

        public State(List<String> visit, boolean[] used, int usedNum){
            this.visit = new LinkedList(visit);
            this.used = Arrays.copyOf(used, used.length);
            this.usedNum = usedNum;
        }
    }
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (String[] a, String[] b)->{
            if(!a[0].equals(b[0]))
                return a[0].compareTo(b[0]);
            else if (!a[1].equals(b[1]))
                return a[1].compareTo(b[1]);
            else
                return 0;
        });

        Stack<State> st = new Stack<>();
        List<String> first = new LinkedList<>();
        first.add("ICN");
        st.add(new State(first, new boolean[tickets.length], 0));
        while(!st.empty()){
            State cur = st.pop();
            if(cur.usedNum == tickets.length){
                String[] answer = new String[cur.visit.size()];
                for(int i = 0; i < cur.visit.size(); i++) {
                    answer[i] = cur.visit.get(i);
                }
                return answer;
            }

            //st에 마지막에 쌓인 것부터 실행되므로, 알파벳 순서때문에 뒤에서부터 읽어야함
            for(int i = tickets.length-1; i >= 0 ; i--) {
                String[] ticket = tickets[i];
                if(cur.used[i]==false && cur.visit.get(cur.visit.size()-1).equals(ticket[0])){
                    State next = new State(cur.visit, cur.used, cur.usedNum);
                    next.used[i]=true;
                    next.usedNum++;
                    next.visit.add(ticket[1]);
                    st.add(next);
                }
            }
        }
        return null;
    }

    //Backtracking 풀이
//    public String[] solution(String[][] tickets) {
//        Arrays.sort(tickets, (String[] a, String[] b)->{
//            if(!a[0].equals(b[0]))
//                return a[0].compareTo(b[0]);
//            else if (!a[1].equals(b[1]))
//                return a[1].compareTo(b[1]);
//            else
//                return 0;
//        });
//        Stack<String> answer = new Stack<>();
//        answer.push("ICN");
//        boolean[] used = new boolean[tickets.length];
//        DFS(tickets, used, answer, 0);
//
//        String[] ret = new String[answer.size()];
//        for(int j = 0; j < answer.size();j++){
//            ret[j] = answer.get(j);
//        }
//        return ret;
//    }
//
//    boolean DFS(String[][] tickets, boolean[] used, Stack<String> visit, int usedNum){
//        if(usedNum == tickets.length)
//            return true;
//
//        for(int i = 0; i < tickets.length; i++) {
//            if(used[i] == false && tickets[i][0].equals(visit.peek())){
//                used[i] = true;
//                visit.push(tickets[i][1]);
//                if(DFS(tickets, used, visit, usedNum + 1))
//                    return true;
//                used[i] = false;
//                visit.pop();
//            }
//        }
//        return false;
//    }
}
