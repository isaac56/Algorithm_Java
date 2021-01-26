package programmers;
import java.util.*;

public class 단어변환 {
    private boolean possible(String s1, String s2){
        int num = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                num++;
        }
        return num <= 1;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visit = new boolean[words.length];
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(begin, 0));
        while(!queue.isEmpty()){
            State state = queue.remove();
            String curString = state.curString;
            int curNum = state.num;
            if(state.curString.equals(target))
                return curNum;

            for(int i = 0; i < words.length; i++) {
                if(!visit[i] && possible(curString, words[i])){
                    visit[i] = true;
                    queue.add(new State(words[i],curNum+1));
                }
            }
        }

        return answer;
    }

    class State{
        String curString;
        int num;

        State(String cur, int num){
            this.curString = cur;
            this.num = num;
        }
    }
}
