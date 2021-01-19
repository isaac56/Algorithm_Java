package programmers;
import java.util.*;

public class 조이스틱 {
    class Horizon{
        public int right;
        public int left;
        Horizon (int right, int left) {
            this.right = right;
            this.left = left;
        }
    }
    public int solution(String name) {
        List<Horizon> list = new ArrayList<>();
        int verticalMin = 0;
        int alphaNum = (int)('Z' - 'A');
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) != 'A'){
                char cur = name.charAt(i);
                int up = (int)(cur - 'A');
                int down = (int)('Z' - cur + 1);
                verticalMin += up < down ? up : down;
            }
        }

        for(int i = 1 ; i < name.length(); i++) {
            if(name.charAt(i) != 'A'){
                list.add(new Horizon(i,name.length()-i));
            }
        }

        int horizonMin = list.size() > 0 ? list.get(list.size() - 1).right : 0;
        for(int i = 0; i < list.size(); i++) {
            if(i+1 < list.size()){
                if(horizonMin > list.get(i).right*2 + list.get(i+1).left)
                    horizonMin = list.get(i).right*2 + list.get(i+1).left;
                if(horizonMin > list.get(i+1).left*2 + list.get(i).right)
                    horizonMin = list.get(i+1).left*2 + list.get(i).right;
            }
            if(i == 0){
                if(horizonMin > list.get(i).left)
                    horizonMin = list.get(i).left;
            }
            if(i == list.size()-1){
                if(horizonMin > list.get(i).right)
                    horizonMin = list.get(i).right;
            }
        }
        return verticalMin + horizonMin;
    }
}
