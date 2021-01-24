package programmers;
import java.util.*;

public class 네트워크 {
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
