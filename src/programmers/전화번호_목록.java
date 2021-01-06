package programmers;
import java.util.*;

public class 전화번호_목록 {
    // 정렬로 풀기
    // 사용법 숙지를 위해 Comparator와 Collections.reverseOrder() 사용하였습니다.
    public boolean solution(String[] phone_book) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Arrays.sort(phone_book, Collections.reverseOrder());

        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i].contains(phone_book[i+1]))
                return false;
        }

        return true;
    }

    // Hash로 풀기
    public boolean solution2(String[] phone_book) {
        HashMap<String, Boolean> hm = new HashMap<>();
        for(String name : phone_book) {
            hm.put(name, true);
        }

        for(String name : phone_book) {
            for(int i = 1; i < name.length(); i++) {
                if(hm.containsKey(name.substring(0, i)))
                    return false;
            }
        }
        return true;
    }
}

