package programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 파일명정렬 {
    public class File implements Comparable<File> {
        public String origin;
        public String header;
        public int number;

        File(String origin) {
            this.origin = origin;
            Pattern pattern = Pattern.compile("[0-9]{1,5}");
            Matcher matcher = pattern.matcher(origin);
            matcher.find();
            String matched = matcher.group();
            int split = origin.indexOf(matched);
            this.header = origin.substring(0, split).toLowerCase();
            this.number = Integer.valueOf(matched);
        }

        @Override
        public int compareTo(File o) {
            if (!this.header.equals(o.header)) {
                return this.header.compareTo(o.header);
            }
            if (this.number < o.number) {
                return -1;
            } else if (this.number > o.number) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        for (String fileName : files) {
            fileList.add(new File(fileName));
        }
        Collections.sort(fileList);
        String[] answer = new String[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).origin;
        }

        return answer;
    }
}
