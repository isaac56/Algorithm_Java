package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 블록_이동하기 {
    class State{
        int time;
        Location loc;

        State (Location loc, int time){
            this.loc = loc;
            this.time = time;
        }
    }

    class Location{
        int x1, y1;
        int x2, y2;

        Location(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        Location(Location location){
            this.x1 = location.x1;
            this.x2 = location.x2;
            this.y1 = location.y1;
            this.y2 = location.y2;
        }

        int getType(){
            if(x1 == x2){
                return 0;
            }else {
                return 1;
            }
        }

        Location HRotate1(int[][] board){
            if(board.length <= x1+1)
                return null;
            if(board[x1+1][y1] != 0 || board[x2+1][y2] != 0)
                return null;

            return new Location(x1,y1,x1+1,y1);
        }

        Location HRotate1_R(int[][] board){
            if(x1-1 < 0)
                return null;
            if(board[x1-1][y1] != 0 || board[x2-1][y2] != 0)
                return null;

            return new Location(x1-1,y1,x1,y1);
        }

        Location HRotate2(int[][] board){
            if(x1-1 < 0)
                return null;
            if(board[x1-1][y1] != 0 || board[x2-1][y2] != 0)
                return null;

            return new Location(x2-1,y2,x2,y2);
        }

        Location HRotate2_R(int[][] board){
            if(board.length <= x1+1)
                return null;
            if(board[x1+1][y1] != 0 || board[x2+1][y2] != 0)
                return null;

            return new Location(x2,y2,x2+1,y2);
        }

        Location VRotate1(int[][] board){
            if(y1-1 < 0)
                return null;
            if(board[x1][y1-1] != 0 || board[x2][y2-1] != 0)
                return null;

            return new Location(x1,y1-1,x1,y1);
        }

        Location VRotate1_R(int[][] board){
            if(board.length <= y1+1)
                return null;
            if(board[x1][y1+1] != 0 || board[x2][y2+1] != 0)
                return null;

            return new Location(x1,y1,x1,y1+1);
        }

        Location VRotate2(int[][] board){
            if(board.length <= y1+1)
                return null;
            if(board[x1][y1+1] != 0 || board[x2][y2+1] != 0)
                return null;

            return new Location(x2,y2,x2,y2+1);
        }

        Location VRotate2_R(int[][] board){
            if(y1-1 < 0)
                return null;
            if(board[x1][y1-1] != 0 || board[x2][y2-1] != 0)
                return null;

            return new Location(x2,y2-1,x2,y2);
        }

        Location right(int[][] board){
            if(board.length <= y2+1)
                return null;
            if(board[x1][y1+1] != 0 || board[x2][y2+1] != 0)
                return null;

            return new Location(x1, y1+1, x2, y2+1);
        }

        Location left(int[][] board){
            if(y1 - 1 < 0)
                return null;
            if(board[x1][y1-1] != 0 || board[x2][y2-1] != 0)
                return null;

            return new Location(x1 ,y1-1, x2, y2-1);
        }

        Location down(int[][] board){
            if(board.length <= x2+1)
                return null;
            if(board[x1+1][y1] != 0 || board[x2+1][y2] != 0)
                return null;

            return new Location(x1+1,y1,x2+1,y2);
        }

        Location up(int[][] board){
            if(x1 - 1 < 0)
                return null;
            if(board[x1-1][y1] != 0 || board[x2-1][y2] != 0)
                return null;

            return  new Location(x1-1, y1, x2-1, y2);
        }

        boolean visited(boolean[][][] visit){
            int t = getType();
            return visit[x1][y1][t] && visit[x2][y2][t];
        }

        void visit(boolean[][][] visit){
            int t = getType();
            visit[x1][y1][t] = true;
            visit[x2][y2][t] = true;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visit = new boolean[board.length][board.length][2];
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(new Location(0,0,0,1), 0));
        while(!queue.isEmpty()){
            State curState = queue.remove();
            Location curLoc = curState.loc;
            int curTime = curState.time;
            if(curLoc.x2 == n-1 && curLoc.y2 == n-1)
                return curTime;

            Location nextLoc;
            if((nextLoc = curLoc.right(board)) != null){
                if(!nextLoc.visited(visit)){
                    nextLoc.visit(visit);
                    queue.add(new State(nextLoc, curTime+1));
                }
            }
            if((nextLoc = curLoc.left(board)) != null){
                if(!nextLoc.visited(visit)){
                    nextLoc.visit(visit);
                    queue.add(new State(nextLoc, curTime+1));
                }
            }
            if((nextLoc = curLoc.down(board)) != null){
                if(!nextLoc.visited(visit)){
                    nextLoc.visit(visit);
                    queue.add(new State(nextLoc, curTime+1));
                }
            }
            if((nextLoc = curLoc.up(board)) != null){
                if(!nextLoc.visited(visit)){
                    nextLoc.visit(visit);
                    queue.add(new State(nextLoc, curTime+1));
                }
            }
            if(curLoc.getType() == 0) {
                if((nextLoc = curLoc.HRotate1(board)) != null){
                    if(!nextLoc.visited(visit)){
                        nextLoc.visit(visit);
                        queue.add(new State(nextLoc, curTime+1));
                    }
                }
                if((nextLoc = curLoc.HRotate1_R(board)) != null){
                    if(!nextLoc.visited(visit)){
                        nextLoc.visit(visit);
                        queue.add(new State(nextLoc, curTime+1));
                    }
                }
                if((nextLoc = curLoc.HRotate2(board)) != null){
                    if(!nextLoc.visited(visit)){
                        nextLoc.visit(visit);
                        queue.add(new State(nextLoc, curTime+1));
                    }
                }
                if((nextLoc = curLoc.HRotate2_R(board)) != null){
                    if(!nextLoc.visited(visit)){
                        nextLoc.visit(visit);
                        queue.add(new State(nextLoc, curTime+1));
                    }
                }
            }
            else {
                if ((nextLoc = curLoc.VRotate1(board)) != null) {
                    if (!nextLoc.visited(visit)) {
                        nextLoc.visit(visit);
                        queue.add(new State(nextLoc, curTime + 1));
                    }
                }
                if ((nextLoc = curLoc.VRotate1_R(board)) != null) {
                    if (!nextLoc.visited(visit)) {
                        nextLoc.visit(visit);
                        queue.add(new State(nextLoc, curTime + 1));
                    }
                }
                if ((nextLoc = curLoc.VRotate2(board)) != null) {
                    if (!nextLoc.visited(visit)) {
                        nextLoc.visit(visit);
                        queue.add(new State(nextLoc, curTime + 1));
                    }
                }
                if ((nextLoc = curLoc.VRotate2_R(board)) != null) {
                    if (!nextLoc.visited(visit)) {
                        nextLoc.visit(visit);
                        queue.add(new State(nextLoc, curTime + 1));
                    }
                }
            }
        }
        return 0;
    }
    
    void print(int[][] board, Location loc){
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(loc.x1 == i && loc.y1 == j){
                    System.out.print("2 ");
                }else if (loc.x2 == i && loc.y2 == j){
                    System.out.print("2 ");
                }
                else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
