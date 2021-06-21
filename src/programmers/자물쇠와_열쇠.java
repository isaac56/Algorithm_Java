package programmers;

public class 자물쇠와_열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        if (isKey(key, lock)) {
            return true;
        }
        key = rotate(key);
        if (isKey(key, lock)) {
            return true;
        }
        key = rotate(key);
        if (isKey(key, lock)) {
            return true;
        }
        key = rotate(key);
        if (isKey(key, lock)) {
            return true;
        }

        return false;
    }

    private boolean isKey(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;

        for (int rowOffset = -(N - 1); rowOffset < M; rowOffset++) {
            for (int colOffset = -(N - 1); colOffset < M; colOffset++) {
                if (isAnswer(key, lock, rowOffset, colOffset)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAnswer(int[][] key, int[][] lock, int rowOffset, int colOffset) {
        int M = key.length;
        int N = lock.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (0 <= i + rowOffset && i + rowOffset < M && 0 <= j + colOffset && j + colOffset < M) {
                    if (key[i + rowOffset][j + colOffset] + lock[i][j] != 1) {
                        return false;
                    }
                } else if (lock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private void print(int[][] key) {
        for (int[] row : key) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private int[][] rotate(int[][] key) {
        int M = key.length;
        int[][] ret = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                ret[j][M - 1 - i] = key[i][j];
            }
        }

        return ret;
    }
}
