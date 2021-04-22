package programmers;

import sun.jvm.hotspot.utilities.IntArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실패율 {
    class Fail implements Comparable<Fail> {
        int stage;
        double value;

        @Override
        public int compareTo(Fail o) {
            if (this.value != o.value) {
                return -Double.compare(this.value, o.value);
            } else {
                return Integer.compare(this.stage, o.stage);
            }
        }

        public Fail(int stage, double value) {
            this.stage = stage;
            this.value = value;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] userNum = new int[N + 2];
        for (int stage : stages) {
            userNum[stage]++;
        }

        List<Fail> answerList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            answerList.add(new Fail(i, getFailValue(i, userNum)));
        }

        Collections.sort(answerList);

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = answerList.get(i).stage;
        }

        return answer;
    }

    public double getFailValue(int stage, int[] userNum) {
        double tryingUser = userNum[stage];
        double allUser = 0;
        for (int i = stage; i < userNum.length; i++) {
            allUser += userNum[i];
        }

        System.out.println(stage + "의 실패율: " + tryingUser + " / " + allUser);

        if (allUser == 0) {
            return 0;
        }
        
        return tryingUser / allUser;
    }
}
