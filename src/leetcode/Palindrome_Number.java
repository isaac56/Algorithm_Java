package leetcode;

public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        String sX = Integer.toString(x);
        for(int i = 0; i < sX.length()/2; i++) {
            if(sX.charAt(i) != sX.charAt(sX.length()-1 - i))
                return false;
        }
        return true;
    }
}
