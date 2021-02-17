package programmers;

import java.util.*;

public class 신규아이디추천 {
    public String solution(String new_id){
        String answer = new_id;
        answer = phase1(answer);
        answer = phase2(answer);
        answer = phase3(answer);
        answer = phase4(answer);
        answer = phase5(answer);
        answer = phase6(answer);
        answer = phase7(answer);
        return answer;
    }

    String phase1(String id){
        return id.toLowerCase();
    }

    String phase2(String id){
        String[] tmp = id.split("[^a-z-_.0-9]");
        return Arrays.stream(tmp).reduce("",(a,b)->a+b);
    }

    String phase3(String id){
        StringBuilder builder = new StringBuilder();
        if(id.length() > 0){
            builder.append(id.charAt(0));
        }
        for(int i = 1; i < id.length(); i++) {
            if(id.charAt(i-1) == '.' && id.charAt(i) == '.')
                continue;
            builder.append(id.charAt(i));
        }
        return builder.toString();
    }

    String phase4(String id){
        if(id.length() > 0 && id.charAt(0) == '.'){
            id = id.substring(1);
        }
        if(id.length() > 0 && id.charAt(id.length()-1) == '.'){
            id = id.substring(0, id.length()-1);
        }
        return id;
    }

    String phase5(String id){
        if(id.isEmpty()){
            return "a";
        }
        return id;
    }

    String phase6(String id){
        if(id.length() >= 16){
            id = phase4(id.substring(0,15));
        }
        return id;
    }

    String phase7(String id){
        if(id.length() <= 2){
            char last = id.charAt(id.length()-1);
            int num = 3 - id.length();
            for(int i = 0; i < num; i++) {
                id += last;
            }
        }
        return id;
    }
}
