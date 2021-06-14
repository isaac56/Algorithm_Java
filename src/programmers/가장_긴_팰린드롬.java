package programmers;

public class 가장_긴_팰린드롬 {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (answer < j - i + 1 && palindrome(i, j, s)) {
                    answer = j - i + 1;
                }
            }
        }
        return answer;
    }

    private boolean palindrome(int left, int right, String s) {
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
