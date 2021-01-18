package programmers;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        for(int y = 1; y <= Math.sqrt(yellow); y++) {
            if(yellow % y == 0) {
                int x = yellow / y;
                int curBrown = x*2 + y*2 +4;
                if(curBrown == brown)
                    return new int[]{x+2,y+2};
            }
        }
        int[] answer = {};
        return answer;
    }
}
