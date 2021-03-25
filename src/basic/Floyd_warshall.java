package basic;

public class Floyd_warshall {
    //fee[i][j]는 i에서부터 j까지 직접 가는 비용 입니다.
    //fee[i][j]와 fee[j][i]는 같은 값으로 초기화 되어 있습니다.
    //fee[i][j]가 무한대(맥스값)으로 설정되어 있으면 i와 j는 연결되지 않은 것입니다.
    //floyd_warshall이 끝난 후 fee[i][j]는 i에서부터 j까지 가는 최소 비용입니다. (경유하여 가는 경우까지 포함하여)
    public void floyd_warshall(int[][] fee, int n) {
        for (int stopOver = 1; stopOver <= n; stopOver++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    fee[start][end] = Math.min(fee[start][end], fee[start][stopOver] + fee[stopOver][end]);
                }
            }
        }
    }
}
