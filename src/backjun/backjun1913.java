package backjun;

import java.util.Scanner;

public class backjun1913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();

        int[][] arr = new int[N][N];
        int value = N * N;
        int width = N - 1;
        int height = N - 1;
        int i = 0;
        int j = 0;

        while (value > 0) {
            if (value == 1) {
                arr[i][j] = 1;
                break;
            }
            for (int k = 0; k < height; k++) {
                arr[i++][j] = value--;
            }
            for (int k = 0; k < width; k++) {
                arr[i][j++] = value--;
            }
            for (int k = 0; k < height; k++) {
                arr[i--][j] = value--;
            }
            for (int k = 0; k < width; k++) {
                arr[i][j--] = value--;
            }
            width -= 2;
            height -= 2;
            i++;
            j++;
        }

        StringBuilder sb = new StringBuilder();
        int row = 0, col = 0;
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                sb.append(arr[k][l]);
                sb.append(' ');
                if (arr[k][l] == target) {
                    row = k + 1;
                    col = l + 1;
                }
            }
            sb.append('\n');
        }

        sb.append(row);
        sb.append(' ');
        sb.append(col);
        System.out.println(sb.toString());
    }
}
