package programmers;

import java.util.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        for(int i = people.length-1; i >= 0; i--){
            if(min <= i){
                if(min != i && people[min] + people[i] <= limit){
                    min++;
                }
                answer++;
            }
            else {
                break;
            }
        }

        return answer;
    }
}

