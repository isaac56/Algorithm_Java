package programmers;

import java.util.*;

public class 문자열_압축 {
    public int solution(String s) {
        int minLength = s.length();
        int maxUnit = s.length() / 2;
        for (int unit = 1; unit <= maxUnit; unit++) {
            int curLength = getLength(unit, s);
            if (curLength < minLength) {
                minLength = curLength;
            }
        }
        return minLength;
    }

    int getLength(int unit, String s) {
        int length = s.length();
        String currentSub = "";
        int repeatNum = 0;
        for (int i = 0; i + unit <= s.length(); i += unit) {
            if (currentSub.equals(s.substring(i, i + unit))) {
                repeatNum++;
                if (repeatNum > 1) {
                    length -= unit;
                }
            } else {
                if (repeatNum > 1) {
                    length += String.valueOf(repeatNum).length();
                }
                currentSub = s.substring(i, i + unit);
                repeatNum = 1;
            }
        }
        if (repeatNum > 1) {
            length += String.valueOf(repeatNum).length();
        }
        return length;
    }
}
