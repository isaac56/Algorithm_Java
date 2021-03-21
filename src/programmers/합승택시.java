package programmers;

import java.util.*;

public class 합승택시 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int MAX_VALUE = 300000000;
        int[][] fee = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    fee[i][j] = 0;
                } else {
                    fee[i][j] = MAX_VALUE;
                }
            }
        }

        for (int[] fare : fares) {
            fee[fare[0]][fare[1]] = fare[2];
            fee[fare[1]][fare[0]] = fare[2];
        }
        floyd_warshall(fee, n);

        int answer = MAX_VALUE;
        for (int stopOver = 1; stopOver <= n; stopOver++) {
            answer = Math.min(answer, fee[s][stopOver] + fee[stopOver][a] + fee[stopOver][b]);
        }
        return answer;
    }

    public void floyd_warshall(int[][] fee, int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    fee[i][j] = Math.min(fee[i][j], fee[i][k] + fee[k][j]);
                }
            }
        }
    }
}
