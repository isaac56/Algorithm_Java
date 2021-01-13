package leetcode;

public class Reverse_Integer {
    //내 풀이
    public int reverse(int x) {
        String sInt = Integer.toString(x);
        String sMax = Integer.toString(Integer.MAX_VALUE);
        String sMin = Integer.toString(Integer.MIN_VALUE);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 1; i < sInt.length(); i++) {
            stringBuilder.insert(0, sInt.charAt(i));
        }
        if(sInt.charAt(0) == '-'){
            stringBuilder.insert(0, sInt.charAt(0));
        }
        else{
            stringBuilder.append(sInt.charAt(0));
        }
        String sReverse = stringBuilder.toString();

        if(x >= 0 && sMax.length() == sReverse.length() && sMax.compareTo(sReverse) < 0)
            return 0;

        if(x < 0 && sMin.length() == sReverse.length() && sMin.compareTo(sReverse) < 0)
            return 0;

        return Integer.valueOf(sReverse);
    }

    //Solution 보고 풀어본 풀이
    public int reverse2(int x) {
        int rev = 0;
        while(x != 0){
            rev *= 10;
            rev += x % 10;
            if(x >= 10 && rev > Integer.MAX_VALUE/10)
                return 0;
            if(x <= -10 && rev < Integer.MIN_VALUE/10)
                return 0;
            x /= 10;
        }
        return rev;
    }
}
