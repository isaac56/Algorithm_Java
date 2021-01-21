package programmers;

import java.util.*;

public class 불량_사용자 {
    public class State{
        HashSet<Integer> hs;
        int cur;
        public State(HashSet<Integer> hs, int cur){
            this.hs = hs;
            this.cur = cur;
        }
    }

    public boolean match(String ban, String user) {
        if(ban.length() != user.length())
            return false;

        for(int i = 0; i < ban.length(); i++) {
            if(ban.charAt(i) != '*' && ban.charAt(i) != user.charAt(i))
                return false;
        }
        return true;
    }

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        HashSet<HashSet<Integer>> total = new HashSet<>();

        Stack<State> st = new Stack<>();
        st.push(new State(new HashSet<>(), 0));
        while(!st.empty()){
            State state = st.pop();
            HashSet<Integer> curHs = state.hs;
            int cur = state.cur;

            if(cur == banned_id.length){
                total.add(curHs);
                continue;
            }

            String ban = banned_id[cur];
            for(int i = 0; i < user_id.length; i++) {
                if(!curHs.contains(i) && match(ban, user_id[i])){
                    HashSet<Integer> nextHs = new HashSet<>(curHs);
                    nextHs.add(i);
                    st.push(new State(nextHs,cur+1));
                }
            }
        }
        return total.size();
    }
}
