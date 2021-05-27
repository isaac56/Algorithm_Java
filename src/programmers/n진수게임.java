package programmers;

public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int number = 0;
        String totalResult = "";
        while (totalResult.length() < t * m) {
            totalResult += parseN(number++, n);
        }
        for (int i = 0; i < t; i++) {
            answer += totalResult.charAt(i * m + p - 1);
        }
        return answer;
    }

    private char getChar(int number) {
        if (number < 10) {
            return (char) ('0' + number);
        }
        return (char) ('A' + (number - 10));
    }

    private String parseN(int number, int n) {
        if (number == 0) {
            return "0";
        }

        String ret = "";
        while (number / n > 0) {
            ret = getChar(number % n) + ret;
            number /= n;
        }
        if (number > 0) {
            ret = getChar(number) + ret;
        }
        return ret;
    }
}
