package backjun;
import java.util.*;

public class backjun1052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int toBuy = 0;
        while(true) {
            int totalN = N + toBuy;
            int min = 0;
            while(totalN > 0){
                min += totalN % 2;
                totalN /= 2;
            }

            if(min <= K)
                break;
            toBuy++;
        }
        System.out.println(toBuy);

        sc.close();
    }
}
