package programmers;

public class 가장큰정사각형찾기 {
    public int solution(int[][] board) {
        int rSize = board.length;
        int cSize = board[0].length;
        int[][] history = new int[rSize][cSize];

        for (int i = 0; i < rSize; i++) {
            history[i][0] = board[i][0];
        }
        for (int j = 0; j < cSize; j++) {
            history[0][j] = board[0][j];
        }

        for (int i = 1; i < rSize; i++) {
            for (int j = 1; j < cSize; j++) {
                if (board[i][j] == 1) {
                    int min = history[i - 1][j];
                    if (min > history[i][j - 1]) {
                        min = history[i][j - 1];
                    }
                    if (min > history[i - 1][j - 1]) {
                        min = history[i - 1][j - 1];
                    }
                    history[i][j] = min + 1;
                } else {
                    history[i][j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < cSize; j++) {
                if (answer < history[i][j]) {
                    answer = history[i][j];
                }
            }
        }

        return answer * answer;
    }
}
