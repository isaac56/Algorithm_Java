package programmers;
import java.util.*;

public class 디스크컨트롤러 {
    class Job implements Comparable<Job> {
        public int start;
        public int time;

        public Job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Job other) {
            if(this.time < other.time) {
                return -1;
            }
            else if(this.time > other.time) {
                return 1;
            }
            else
                return 0;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                else if(o1[0] > o2[0]) return 1;
                else return 0;
            }
        };
        Arrays.sort(jobs,comp);

        PriorityQueue<Job> pq = new PriorityQueue<>();
        int currentTime = 0;
        for(int[] job : jobs) {
            while(!pq.isEmpty() && currentTime < job[0]) {
                Job top = pq.remove();
                currentTime += top.time;
                answer += currentTime - top.start;
            }
            if(currentTime < job[0]) currentTime = job[0];
            pq.add(new Job(job[0],job[1]));
        }
        while(!pq.isEmpty()) {
            Job top = pq.remove();
            currentTime += top.time;
            answer += currentTime - top.start;
        }

        System.out.println(answer);
        return answer / jobs.length;
    }
}
