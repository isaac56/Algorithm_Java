package programmers;

import java.util.Arrays;

public class 셔틀버스 {
    class Time implements Comparable<Time>{
        int hour;
        int min;
        public Time(String s){
            String[] arr = s.split(":");
            this.hour = Integer.valueOf(arr[0]);
            this.min = Integer.valueOf(arr[1]);
        }

        public void addMin(int addMin){
            int total = this.min + addMin;
            if(total >= 0){
                this.hour += (total)/60;
                this.min = (total)%60;
            }
            else {
                this.hour += total%60 != 0 ? total/60 - 1 : total/60;
                this.min = total%60 != 0 ? total%60 + 60 : 0;
            }
        }

        @Override
        public int compareTo(Time other){
            if(this.hour < other.hour){
                return -1;
            } else if (this.hour > other.hour){
                return 1;
            } else if (this.min < other.min){
                return -1;
            } else if (this.min > other.min){
                return 1;
            } else
                return 0;
        }

        @Override
        public String toString(){
            return String.format("%02d:%02d",hour,min);
        }
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        int curIdx = 0;
        Time start = new Time("09:00");
        for(int i = 0; i < n; i++) {
            int num = 0;
            int j = curIdx;
            while(j < timetable.length && num < m){
                Time curTime = new Time(timetable[j]);
                if(curTime.compareTo(start) > 0){
                    break;
                }
                num++;
                j++;
            }
            if(i == n-1){
                if(j == 0) {
                    return start.toString();
                }
                if(num < m) {
                    return start.toString();
                }
                else{
                    Time ret = new Time(timetable[j-1]);
                    ret.addMin(-1);
                    return ret.toString();
                }
            }
            start.addMin(t);
            curIdx = j;
        }
        return answer;
    }
}
