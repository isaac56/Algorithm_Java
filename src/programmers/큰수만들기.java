package programmers;

import java.util.Arrays;

public class 큰수만들기 {
    public String solution(String number, int k) {
        char[] charArr = number.toCharArray();
        for(int i = k - 1; i >=0; i--){
            for(int j = k; j < charArr.length; j++) {
                if(charArr[i] >= charArr[j]){
                    char temp = charArr[i];
                    charArr[i] = charArr[j];
                    charArr[j] = temp;
                }
                else
                    break;
            }
        }

        return String.valueOf(Arrays.copyOfRange(charArr, k, charArr.length));
    }
}

