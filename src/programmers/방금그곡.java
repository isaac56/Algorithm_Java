package programmers;

import java.util.Arrays;

public class 방금그곡 {
    class Info {
        String name;
        int playTime;
        String playedMusic;

        public Info(String name, int playTime, String playedMusic) {
            this.name = name;
            this.playTime = playTime;
            this.playedMusic = playedMusic;
        }
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        Info[] infos = new Info[musicinfos.length];
        for (int i = 0; i < musicinfos.length; i++) {
            String musicInfo = musicinfos[i];
            String[] split = musicInfo.split(",");
            int playTime = getMinute(split[1]) - getMinute(split[0]);
            String name = split[2];
            String fullMusic = getFull(playTime, getSimple(split[3]));

            infos[i] = new Info(name, playTime, fullMusic);
        }

        Arrays.sort(infos, (a, b) -> {
            if (a.playTime > b.playTime) {
                return -1;
            } else if (a.playTime < b.playTime) {
                return 1;
            } else {
                return 0;
            }
        });

        m = getSimple(m);
        for (Info info : infos) {
            if (info.playedMusic.contains(m)) {
                return info.name;
            }
        }

        return "(None)";
    }

    public int getMinute(String time) {
        int hour = Integer.valueOf(time.split(":")[0]);
        int minute = Integer.valueOf(time.split(":")[1]);
        return hour * 60 + minute;
    }

    public String getSimple(String music) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < music.length()) {
            if (index + 1 < music.length() && music.charAt(index + 1) == '#') {
                builder.append(Character.toLowerCase(music.charAt(index)));
                index += 2;
            } else {
                builder.append(music.charAt(index));
                index++;
            }
        }
        return builder.toString();
    }

    public String getFull(int minute, String simpleMusic) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, j = 0; i < minute; i++, j = (j + 1) % simpleMusic.length()) {
            builder.append(simpleMusic.charAt(j));
        }
        return builder.toString();
    }
}
