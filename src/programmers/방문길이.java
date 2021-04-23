package programmers;

public class 방문길이 {
    public int solution(String dirs) {
        int[] plusR = new int[]{-1, 0, 1, 0};
        int[] plusC = new int[]{0, 1, 0, -1};
        boolean[][][] visit = new boolean[11][11][4];
        int r = 5;
        int c = 5;

        int answer = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int dir = getDirInt(dirs.charAt(i));
            int nextR = r + plusR[dir];
            int nextC = c + plusC[dir];

            if (isPossible(nextR, nextC)) {
                if (!visit[r][c][dir] && !visit[nextR][nextC][opposit(dir)]) {
                    answer++;
                }
                visit[r][c][dir] = true;
                r = nextR;
                c = nextC;
            }
        }

        return answer;
    }

    public boolean isPossible(int r, int c) {
        return 0 <= r && r <= 10 && 0 <= c && c <= 10;
    }

    public int getDirInt(char dir) {
        switch (dir) {
            case 'U':
                return 0;
            case 'R':
                return 1;
            case 'D':
                return 2;
            case 'L':
                return 3;
        }
        return -1;
    }

    public int opposit(int dir) {
        switch (dir) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 0;
            case 3:
                return 1;
        }
        return -1;
    }
}
