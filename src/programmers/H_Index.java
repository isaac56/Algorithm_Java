package programmers;
import java.util.*;
import java.util.stream.Collectors;

public class H_Index {
    public int solution(int[] citations) {
        List<Integer> cites = Arrays.stream(citations).boxed().collect(Collectors.toList());
        Collections.sort(cites, Collections.reverseOrder());

        int h = cites.size();
        while(h > 0) {
            int num = 0;
            for(int cite : cites) {
                if(cite < h)
                    break;
                num++;
            }
            if(num >= h) {
                return h;
            }
            h--;
        }

        return h;
    }
}
