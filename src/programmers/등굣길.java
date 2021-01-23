package programmers;

public class 등굣길 {
    public int dp(int[][][] cache, int x, int y){
        if(x == 0 && y == 0){
            cache[x][y][0] = 1;
            return cache[x][y][1] = 1;
        }
        if(cache[x][y][0] == 1){
            return cache[x][y][1];
        }
        if(cache[x][y][0] == -1){
            return 0;
        }
        int left = 0, up = 0;
        if(x > 0)
            left = dp(cache, x-1, y);
        if(y > 0)
            up = dp(cache, x, y-1);
        cache[x][y][0] = 1;
        cache[x][y][1] = (left+up) % 1000000007;
        return cache[x][y][1];
    }
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][][] cache = new int[m][n][2];
        for(int[] puddle : puddles){
            cache[puddle[0]-1][puddle[1]-1][0] = -1;
        }
        answer = dp(cache, m-1, n-1);
        return answer;
    }
}
