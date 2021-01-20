package programmers;

import java.util.Arrays;

public class 섬_연결하기 {
    public int getParent(int[] parent, int i){
        if(parent[i] == i)
            return i;
        return parent[i] = getParent(parent, parent[i]);
    }
    public int solution(int n, int[][] costs) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int build = 0;
        int answer = 0;
        Arrays.sort(costs,(a, b) -> {
            if(a[2] < b[2])
                return -1;
            else if(a[2] > b[2])
                return 1;
            else
                return 0;
        });
        for(int i = 0; i < costs.length; i++) {
            int p1 = getParent(parent, costs[i][0]);
            int p2 = getParent(parent, costs[i][1]);
            int cost = costs[i][2];
            if(p1 != p2){
                parent[p1] = p2;
                answer+= cost;
                build++;
            }
            if(build == n-1)
                return answer;
        }
        return answer;
    }
}
