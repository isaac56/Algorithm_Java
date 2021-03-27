package groom.SCF_2.P1;

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NTotal = br.readLine().split(" ");
        int N = Integer.valueOf(NTotal[0]);
        String total = NTotal[1];
        String[] playTimes = new String[N];
        for (int i = 0; i < N; i++) {
            playTimes[i] = br.readLine();
        }
        new Main().solve(N, total, playTimes);
    }

    public void solve(int N, String total, String[] playTimes) {
//        System.out.println(N);
//        System.out.println(total);
//        System.out.println(getTotalSeconds(total));
//        for (String playTime : playTimes) {
//            System.out.println(playTime);
//            System.out.println(getPlaySeconds(playTime));
//        }
        int totalSeconds = getTotalSeconds(total);
        int[] playSeconds = new int[N];
        for (int i = 0; i < N; i++) {
            playSeconds[i] = getPlaySeconds(playTimes[i]);
        }

        int maxPlayNum = 0;
        int answerStart = -1;
        for (int start = 0; start < N; start++) {
            int cur = start;
            int playedSecond = 0;
            int playedNum = 0;
            while (playedSecond < totalSeconds) {
                if (cur >= N) {
                    break;
                }
                playedSecond += playSeconds[cur];
                playedNum++;
                cur++;
            }
            if (playedNum > maxPlayNum) {
                maxPlayNum = playedNum;
                answerStart = start;
            }
        }
        System.out.println(maxPlayNum + " " + (answerStart + 1));
    }

    public int getTotalSeconds(String totalTime) {
        String[] temp = totalTime.split(":");
        int hour = Integer.valueOf(temp[0]);
        int minute = Integer.valueOf(temp[1]);
        int second = Integer.valueOf(temp[2]);
        return hour * 3600 + minute * 60 + second;
    }

    public int getPlaySeconds(String playTime) {
        String[] temp = playTime.split(":");
        int minute = Integer.valueOf(temp[0]);
        int second = Integer.valueOf(temp[1]);
        return minute * 60 + second;
    }
}
