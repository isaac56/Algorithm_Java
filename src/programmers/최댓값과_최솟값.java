package programmers;

public class 최댓값과_최솟값 {
    public String solution(String s) {
        String[] numberStrings = s.split(" ");
        int min = Integer.valueOf(numberStrings[0]);
        int max = min;

        for (String numberString : numberStrings) {
            int current = Integer.valueOf(numberString);
            if (min > current) {
                min = current;
            }
            if (max < current) {
                max = current;
            }
        }
        String answer = min + " " + max;
        return answer;
    }
}
