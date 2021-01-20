package basic;

import java.util.Arrays;

public class Kruskal {
    public int getParent(int[] parent, int n){
        if(parent[n] == n)
            return n;
        return parent[n] = getParent(parent, parent[n]);
    }

    //n은 노드의 개수를 뜻함
    //ways[i][0]과 ways[i][1]은 node id, ways[i][2]는 cost를 뜻함
    //노드가 연결되기 위한 최소 건설 비용을 반환
    public int kruskal(int n, int[][] ways){
        int totalCost = 0, cnt = 0;
        int[] parent = new int[n];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Arrays.sort(ways, (a, b) -> a[2]<b[2] ? -1 : 1);

        for(int[] way : ways) {
            int p1 = getParent(parent, way[0]);
            int p2 = getParent(parent, way[1]);
            int cost = way[2];

            if(p1 != p2){
                parent[p2] = p1;
                totalCost += cost;
                cnt++;
            }
            if(cnt == n-1)
                break;
        }
        return totalCost;
    }
}
