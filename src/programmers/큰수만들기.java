package programmers;

public class 큰수만들기 {
    public String solution(String number, int k) {
        char[] charArr = number.toCharArray();
        for(int i = 1; i <= k; i++) {
            int stdIdx = charArr.length-1 - i;
            for(int j = stdIdx+1; i < charArr.length; i++) {
                if(charArr[stdIdx] < charArr[j]){
                    char temp = charArr[stdIdx];
                    charArr[stdIdx] = charArr[j];
                    charArr[j] = temp;
                }
            }
        }
        return String.valueOf(charArr).substring(0, number.length()-k + 1);
    }
}
