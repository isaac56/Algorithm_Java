package programmers;
import java.util.*;

public class 네트워크 {
// dfs 풀이
    public void dfs(int[] area, int [][] computers, int x, int areaNum){
        area[x] = areaNum;
        int[] connected = computers[x];
        for(int i = 0; i < connected.length; i++) {
            if(connected[i] == 1 && area[i] == 0)
                dfs(area, computers, i, areaNum);
        }
    }

    public int solution2(int n, int[][] computers){
        int answer = 0;
        int[] area = new int[n];
        for(int i = 0; i < n; i++) {
            if(area[i] == 0)
                dfs(area, computers, i, ++answer);
        }

        return answer;
    }

// union-find 풀이
    public int getParent(int[] parent, int x){
        if(parent[x] == x)
            return x;
        return parent[x] = getParent(parent, parent[x]);
    }
    public int solution(int n, int[][] computers) {
        int[] parent = new int[n];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(computers[i][j] == 1){
                    int p1 = getParent(parent, i);
                    int p2 = getParent(parent, j);
                    parent[p1] = p2;
                }
            }
        }
        HashSet<Integer> answer = new HashSet<>();
        for(int i = 0; i < n; i++) {
            answer.add(getParent(parent, i));
        }
        return answer.size();
    }
}
