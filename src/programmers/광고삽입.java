package programmers;

import java.util.*;

public class 광고삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = getSecond(play_time);
        int[] stackCount = new int[playTime + 100];
        int[] startEndCount = new int[playTime + 100];
        for (String log : logs) {
            int[] startEnd = getStartEnd(log);
            startEndCount[startEnd[0]]++;
            startEndCount[startEnd[1]]--;
        }

        int viewer = 0;
        for (int i = 0; i <= playTime; i++) {
            viewer += startEndCount[i];
            stackCount[i] = viewer;
        }

        int advTime = getSecond(adv_time);
        long curStackTime = 0;
        for (int i = 0; i < advTime; i++) {
            curStackTime += stackCount[i];
        }
        long maxStackTime = curStackTime;
        String answer = "00:00:00";
        for (int i = advTime; i < playTime; i++) {
            curStackTime -= stackCount[i - advTime];
            curStackTime += stackCount[i];
            if (curStackTime > maxStackTime) {
                maxStackTime = curStackTime;
                answer = getTime(i - advTime + 1);
            }
        }

        return answer;
    }

    public int getSecond(String time) {
        String[] tmp = time.split(":");
        return Integer.valueOf(tmp[0]) * 3600 + Integer.valueOf(tmp[1]) * 60 + Integer.valueOf(tmp[2]);
    }

    public int[] getStartEnd(String log) {
        String[] tmp = log.split("-");
        return new int[]{getSecond(tmp[0]), getSecond(tmp[1])};
    }

    public String getTime(int second) {
        int hour = second / 3600;
        second %= 3600;
        int min = second / 60;
        second %= 60;
        return String.format("%02d:%02d:%02d", hour, min, second);
    }
}
