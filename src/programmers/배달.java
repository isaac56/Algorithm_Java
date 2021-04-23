package programmers;

import java.util.PriorityQueue;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int INF = 1000000;
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i != j) {
                    map[i][j] = INF;
                }
            }
        }
        for (int[] info : road) {
            if (info[2] < map[info[0]][info[1]]) {
                map[info[0]][info[1]] = info[2];
                map[info[1]][info[0]] = info[2];
            }
        }

        int[] costs = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            costs[i] = INF;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        costs[1] = 0;
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] info = pq.remove();
            int n = info[0];
            int c = info[1];
            if (c <= costs[n]) {
                for (int i = 1; i <= N; i++) {
                    if (c + map[n][i] < costs[i]) {
                        costs[i] = c + map[n][i];
                        pq.add(new int[]{i, costs[i]});
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (costs[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}
