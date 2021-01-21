package programmers;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        int lastIdx = -30001;
        Arrays.sort(routes, (a,b) -> a[1] < b[1] ? -1 : a[1] > b[1] ? 1 : 0);
        for(int i = 0; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            if(lastIdx < start){
                answer++;
                lastIdx = end;
            }
        }
        return answer;
    }
}
