package programmers;
import java.util.*;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> sNumbers = new ArrayList<String>();
        for(int i = 0; i < numbers.length; i++) {
            sNumbers.add(Integer.toString(numbers[i]));
        }

        Collections.sort(sNumbers, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(Integer.parseInt(o1+o2) > Integer.parseInt(o2+o1))
                    return -1;
                else if(Integer.parseInt(o1+o2) < Integer.parseInt(o2+o1))
                    return 1;
                else
                    return 0;
            }
        });

        if(sNumbers.get(0).equals("0"))
            return "0";

        for(String sNumber : sNumbers) {
            answer += sNumber;
        }

        return answer;
    }
}
