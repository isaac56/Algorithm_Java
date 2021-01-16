package programmers;
import java.util.*;

public class 외벽점검 {
    class State {
        public int curWeak;
        public int curFriend;
        public HashSet<Integer> usedDist;
        public int solvedCnt;

        public State(int curWeak, int curFriend, HashSet<Integer> usedDist, int solvedCnt) {
            this.curWeak = curWeak;
            this.curFriend = curFriend;
            this.usedDist = new HashSet<>(usedDist);
            this.solvedCnt = solvedCnt;
        }
    }

    int getDiff(int s, int e, int n) {
        if(s <= e)
            return e - s;
        else
            return n+e - s;
    }

    public int solution(int n, int[] weak, int[] dist) {
        Queue<State> queue = new LinkedList<>();

        for(int i = 0; i < weak.length; i++){
            queue.add(new State(i,dist.length-1, new HashSet<>(),0));
        }

        while(!queue.isEmpty()){
            State curState = queue.remove();
            int curWeak = curState.curWeak;
            int curFriend = curState.curFriend;
            HashSet<Integer> usedDist = curState.usedDist;
            int solvedCnt = curState.solvedCnt;

            int start = weak[curWeak];
            int nextIdx;
            for(nextIdx = curWeak; true; nextIdx = (nextIdx+1)%weak.length){
                if(getDiff(start, weak[nextIdx], n) > dist[curFriend] || solvedCnt == weak.length)
                    break;
                solvedCnt++;
            }
            usedDist.add(curFriend);
            if(solvedCnt == weak.length)
                return usedDist.size();

            for(int i = dist.length-1; i >= 0; i--) {
                if(!usedDist.contains(i)){
                    queue.add(new State(nextIdx,i,usedDist,solvedCnt));
                }
            }
        }
        return -1;
    }
}