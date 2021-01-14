package programmers;

import java.util.*;

public class 기둥과_보_설치 {
    boolean[][][] map;
    int n;
    public boolean isInMap(int x, int y) {
        if(0 <= x && x <= n && 0 <= y && y <= n)
            return true;
        else
            return false;
    }

    public boolean validTop(int x, int y){
        if(!isInMap(x,y)) return false;

        if(y == 0)
            return true;
        if(map[x][y][1])
            return true;
        if(isInMap(x-1,y) && map[x-1][y][1])
            return true;
        if(isInMap(x,y-1) && map[x][y-1][0])
            return true;

        return false;
    }

    public boolean validLine(int x, int y){
        if(!isInMap(x,y)) return false;

        if(isInMap(x,y-1) && map[x][y-1][0])
            return true;
        if(isInMap(x+1,y-1) && map[x+1][y-1][0])
            return true;
        if(isInMap(x-1,y) && isInMap(x+1,y)
            && map[x-1][y][1] && map[x+1][y][1])
            return true;
        return false;
    }

    public void insertTop(int x, int y){
        if(validTop(x,y)){
            map[x][y][0]=true;
//            System.out.println(x+","+y+": inserted");
        }

    }

    public void insertLine(int x, int y){
        if(validLine(x,y)) {
            map[x][y][1] = true;
//            System.out.println(x+","+y+": inserted");
        }
    }

    public void deleteTop(int x, int y) {
        if(map[x][y][0] == false) return;

        map[x][y][0] = false;
        if(isInMap(x,y+1)){
            if(map[x][y+1][0] && !validTop(x,y+1)){
                map[x][y][0] = true;
                return;
            }
            if(map[x][y+1][1] && !validLine(x, y+1))
            {
                map[x][y][0] = true;
                return;
            }
        }

        if(isInMap(x-1,y+1)){
            if(map[x-1][y+1][1] && !validLine(x-1,y+1)){
                map[x][y][0] = true;
                return;
            }
        }
    }

    public void deleteLine(int x, int y) {
        if(map[x][y][1] == false) return;

        map[x][y][1] = false;
        if(isInMap(x-1,y)){
            if(map[x-1][y][1] && !validLine(x-1,y)){
                map[x][y][1] = true;
                return;
            }
        }
        if(isInMap(x,y)){
            if(map[x][y][0] && !validTop(x,y)){
                map[x][y][1] = true;
                return;
            }
        }
        if(isInMap(x+1,y)){
            if(map[x+1][y][0] && !validTop(x+1,y))
            {
                map[x][y][1] = true;
                return;
            }
            if(map[x+1][y][1] && !validLine(x+1,y))
            {
                map[x][y][1] = true;
                return;
            }
        }
    }

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        map = new boolean[n+1][n+1][2];
        List<int[]> answerList = new LinkedList<>();

        for(int[] cmd : build_frame) {
            int x = cmd[0];
            int y = cmd[1];
            int a = cmd[2];
            int b = cmd[3];
            if(a == 0){
                if(b == 0){
                    deleteTop(x,y);
                }
                else {
                    insertTop(x,y);
                }
            }
            else {
                if(b == 0){
                    deleteLine(x,y);
                }
                else {
                    insertLine(x,y);
                }
            }
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                for(int k = 0; k <= 1; k++){
                    if(map[i][j][k])
                        answerList.add(new int[]{i,j,k});
                }
            }
        }

        int[][] answer = new int[answerList.size()][];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        Arrays.sort(answer, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0])
                    return -1;
                else if(o1[0] > o2[0])
                    return 1;
                else{
                    if(o1[1] < o2[1])
                        return -1;
                    else if(o1[1] > o2[1])
                        return 1;
                    else {
                        if(o1[2] < o2[2])
                            return -1;
                        else if(o1[2] > o2[2])
                            return 1;
                        else {
                            return 0;
                        }
                    }
                }
            }
        });

        return answer;
    }
}
