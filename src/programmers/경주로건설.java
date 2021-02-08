package programmers;
import java.util.*;

public class 경주로건설 {
    class State implements Comparable<State>{
        int cost;
        int row;
        int col;
        int type;

        public State(int cost, int row, int col, int type){
            this.cost = cost;
            this.row = row;
            this.col = col;
            this.type = type;
        }

        @Override
        public int compareTo(State other){
            if(cost < other.cost)
                return -1;
            else if(cost > other.cost)
                return 1;
            else
                return 0;
        }
    }
    public int solution(int[][] board){
        int n = board.length;

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};
        boolean[][][] visit = new boolean[n][n][2];
        PriorityQueue<State> queue = new PriorityQueue<>();
        visit[0][0][0] = true;
        visit[0][0][1] = true;
        if(board[0][1] == 0){
            queue.add(new State(100, 0, 1, 0));
        }
        if(board[1][0] == 0){
            queue.add(new State(100,1,0,1));
        }
        while(!queue.isEmpty()){
            State cur = queue.remove();
            visit[cur.row][cur.col][cur.type] = true;
            if(cur.row == n-1 && cur.col == n-1)
                return cur.cost;

            for(int i = 0; i < 4; i++) {
                int nextR = cur.row + dr[i];
                int nextC = cur.col + dc[i];
                int nextT = 0;
                if(nextR != cur.row)
                    nextT = 1;

                if(0 <= nextR && nextR < n && 0 <= nextC && nextC < n
                        && board[nextR][nextC] == 0 && !visit[nextR][nextC][nextT]){
                    if(nextT == cur.type)
                        queue.add(new State(cur.cost+100, nextR, nextC, nextT));
                    else
                        queue.add(new State(cur.cost+600, nextR, nextC, nextT));
                }
            }
        }
        return 0;
    }
}
