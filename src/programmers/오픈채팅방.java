package programmers;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] records) {
        Map<String, String> nickname = new HashMap<>();
        for (String record : records) {
            String[] cmd = record.split(" ");
            if (cmd[0].equals("Enter") || cmd[0].equals("Change")) {
                nickname.put(cmd[1], cmd[2]);
            }
        }
        List<String> answerList = new ArrayList<>();
        for (String record : records) {
            String[] cmd = record.split(" ");
            if (cmd[0].equals("Enter")) {
                answerList.add(nickname.get(cmd[1]) + "님이 들어왔습니다.");
            } else if (cmd[0].equals("Leave")) {
                answerList.add(nickname.get(cmd[1]) + "님이 나갔습니다.");
            }
        }
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
