package programmers;

public class 이상한_문자_만들기 {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == ' '){
                builder.append(cur);
                cnt = 0;
            }
            else{
                if(cnt % 2 == 0){
                    builder.append(Character.toUpperCase(cur));
                }
                else {
                    builder.append(Character.toLowerCase(cur));
                }
                cnt++;
            }
        }
        return builder.toString();
    }
}
