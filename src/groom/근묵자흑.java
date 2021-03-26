package groom;

import java.io.*;

class 근묵자흑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.valueOf(NK[0]);
        int K = Integer.valueOf(NK[1]);
        int[] numbers = new int[N];
        String[] numberStrings = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.valueOf(numberStrings[i]);
        }
        new 근묵자흑().solve(N, K, numbers);
    }

    public void solve(int N, int K, int[] numbers) {
        int minIdx = 0;
        for (int i = 0; i < N; i++) {
            if (numbers[i] == 1) {
                minIdx = i;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = minIdx - (K - 1); i <= minIdx; i++) {
            min = Math.min(min, getNum(i, K, N));
        }
        System.out.println(min);
    }

    public int getNum(int startIdx, int K, int N) {
        int endIdx = startIdx + K - 1;
        return preorderNum(startIdx, K) + postorderNum(endIdx, K, N) + 1;
    }

    public int preorderNum(int startIdx, int K) {
        int num = 0;
        for (int i = startIdx; i > 0; i = i - (K - 1)) {
            num++;
        }
        return num;
    }

    public int postorderNum(int endIdx, int K, int N) {
        int num = 0;
        for (int i = endIdx; i < N - 1; i = i + (K - 1)) {
            num++;
        }
        return num;
    }
}
