package backjun;
import java.util.*;

public class backjun1009 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int a = sc.nextInt() % 10;
            int b = sc.nextInt() % 4;
            if(b == 0) b = 4;

            int r = 1;
            for(int j = 0; j < b; j++) {
                r = (r * a) % 10;
            }
            if (r == 0) r = 10;
            System.out.println(r);
        }
        sc.close();
    }
}
