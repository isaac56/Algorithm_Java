package programmers;
import java.util.*;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n+1];
        for(int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        Arrays.stream(lost).forEach(x -> clothes[x]--);
        Arrays.stream(reserve).forEach(x -> clothes[x]++);

        for(int i = 1; i <= n; i++) {
            if(clothes[i] > 1){
                if(i-1 >= 1 && clothes[i-1] == 0){
                    clothes[i-1]++;
                    clothes[i]--;
                }
                else if(i+1 <= n && clothes[i+1] == 0){
                    clothes[i+1]++;
                    clothes[i]--;
                }
            }
        }

        return (int)Arrays.stream(clothes).filter(x -> x > 0).count();
    }
}
