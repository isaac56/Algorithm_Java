package programmers;
import java.util.*;

public class 경주로건설 {

    //두번째 풀이, BFS로 풀지만 visit 체크 대신
    //cost를 기록하여 더 작은 cost일 때만 방문하도록
   class State{
        int cost;
        int r,c;
        int type; //0은 수평진입, 1은 수직진입

        public State(int cost, int r, int c, int type){
            this.cost = cost;
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }

    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int n = board.length;
        int[][][] cost = new int[n][n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cost[i][j][0] = Integer.MAX_VALUE;
                cost[i][j][1] = Integer.MAX_VALUE;
            }
        }
        Queue<State> queue = new LinkedList<>();
        board[0][0]=1;
        if(board[0][1] == 0){
            queue.add(new State(100, 0, 1, 0));
            cost[0][1][0]=100;
        }
        if(board[1][0] == 0){
            queue.add(new State(100, 1, 0, 1));
            cost[1][0][1]=100;
        }
        while(!queue.isEmpty()){
            State cur = queue.remove();
            if(cur.r == n-1 && cur.c == n-1){
                if(cur.cost < answer)
                    answer = cur.cost;
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nextR = cur.r + dx[i];
                int nextC = cur.c + dy[i];
                int nextType = 0;
                if(cur.r != nextR)
                    nextType = 1;
                int nextCost = cur.cost+100;
                if(cur.type != nextType)
                    nextCost += 500;

                if(0 <= nextR && nextR < n &&
                    0 <= nextC && nextC < n &&
                    board[nextR][nextC] == 0 && nextCost < cost[nextR][nextC][nextType]){
                    queue.add(new State(nextCost, nextR, nextC, nextType));
                    cost[nextR][nextC][nextType] = nextCost;
                }
            }
        }
        return answer;
    }

    //첫번째 풀이(Priority Queue를 통해 복잡하게 풀었음)
//    class State implements Comparable<State>{
//        int cost;
//        int row;
//        int col;
//        int type;
//
//        public State(int cost, int row, int col, int type){
//            this.cost = cost;
//            this.row = row;
//            this.col = col;
//            this.type = type;
//        }
//
//        @Override
//        public int compareTo(State other){
//            if(cost < other.cost)
//                return -1;
//            else if(cost > other.cost)
//                return 1;
//            else
//                return 0;
//        }
//    }
//    public int solution(int[][] board){
//        int n = board.length;
//
//        int[] dr = {0,0,1,-1};
//        int[] dc = {1,-1,0,0};
//        boolean[][][] visit = new boolean[n][n][2];
//        PriorityQueue<State> queue = new PriorityQueue<>();
//        visit[0][0][0] = true;
//        visit[0][0][1] = true;
//        if(board[0][1] == 0){
//            queue.add(new State(100, 0, 1, 0));
//        }
//        if(board[1][0] == 0){
//            queue.add(new State(100,1,0,1));
//        }
//        while(!queue.isEmpty()){
//            State cur = queue.remove();
//            visit[cur.row][cur.col][cur.type] = true;
//            if(cur.row == n-1 && cur.col == n-1)
//                return cur.cost;
//
//            for(int i = 0; i < 4; i++) {
//                int nextR = cur.row + dr[i];
//                int nextC = cur.col + dc[i];
//                int nextT = 0;
//                if(nextR != cur.row)
//                    nextT = 1;
//
//                if(0 <= nextR && nextR < n && 0 <= nextC && nextC < n
//                        && board[nextR][nextC] == 0 && !visit[nextR][nextC][nextT]){
//                    if(nextT == cur.type)
//                        queue.add(new State(cur.cost+100, nextR, nextC, nextT));
//                    else
//                        queue.add(new State(cur.cost+600, nextR, nextC, nextT));
//                }
//            }
//        }
//        return 0;
//    }
}
