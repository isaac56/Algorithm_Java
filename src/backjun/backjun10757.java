package backjun;
import java.util.*;

public class backjun10757 {
    private static String getExtra(int num) {
        String ret = "";
        for(int i = 0; i < num; i++){
            ret += '0';
        }
        return ret;
    }

    private static int[] fulladder(int a, int b, int carry) {
        int sum = a + b + carry;
        return new int[]{sum%10, sum/10};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        if(A.length() > B.length()) {
            int extra = A.length() - B.length();
            B = getExtra(extra) + B;
        }
        else {
            int extra = B.length() - A.length();
            A = getExtra(extra) + A;
        }

        String result = "";
        int carry = 0;
        for(int i = A.length() - 1; i>=0; i--) {
            int n1 = Integer.parseInt(A.substring(i,i+1));
            int n2 = Integer.parseInt(B.substring(i,i+1));
            int[] ret = fulladder(n1,n2,carry);
            result = ret[0] + result;
            carry = ret[1];
        }
        if(carry != 0) result = carry + result;
        System.out.println(result);

        sc.close();
    }
}
