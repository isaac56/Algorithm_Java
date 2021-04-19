package programmers;

import java.util.List;

public class 프렌즈블록 {
    public static void main(String[] args) {
        프렌즈블록 t = new 프렌즈블록();
        t.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    }

    public int solution(int m, int n, String[] boardS) {
        char[][] board = new char[m][n];

        for (int i = 0; i < m; i++) {
            String row = boardS[i];
            for (int j = 0; j < n; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        int answer = 0;

        boolean marked = false;
        do {
            marked = false;
            boolean[][] deleted = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mark(i, j, board, deleted)) {
                        marked = true;
                    }
                }
            }

            char[][] nextBoard = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nextBoard[i][j] = '.';
                }
            }
            for (int j = 0; j < n; j++) {
                int row = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (deleted[i][j] == false) {
                        nextBoard[row][j] = board[i][j];
                        row--;
                    } else {
                        answer++;
                    }
                }
            }
            board = nextBoard;

        } while (marked);

        return answer;
    }

    public boolean mark(int x, int y, char[][] board, boolean[][] deleted) {
        int m = board.length;
        int n = board[0].length;
        char C = board[x][y];

        int[] plusX = new int[]{0, 1, 1};
        int[] plusY = new int[]{1, 0, 1};
        for (int i = 0; i < 3; i++) {
            int nextX = x + plusX[i];
            int nextY = y + plusY[i];
            if (nextX < 0 || m <= nextX ||
                    nextY < 0 || n <= nextY) {
                return false;
            }
            if (board[nextX][nextY] == '.') {
                return false;
            }
            if (board[nextX][nextY] != C) {
                return false;
            }
        }

        deleted[x][y] = true;
        for (int i = 0; i < 3; i++) {
            int nextX = x + plusX[i];
            int nextY = y + plusY[i];
            if (nextX < 0 || m <= nextX ||
                    nextY < 0 || n <= nextY) {

            } else {
                deleted[nextX][nextY] = true;
            }

        }
        return true;
    }
}
