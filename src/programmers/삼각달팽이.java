package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 삼각달팽이 {
    class State {
        int r;
        int c;
        int value;
        int dir;

        State(int r, int c, int value, int dir) {
            this.r = r;
            this.c = c;
            this.value = value;
            this.dir = dir;
        }
    }

    public int[] solution(int n) {
        int[][] pyramid = new int[n + 1][n + 1];

        Stack<State> st = new Stack<>();
        st.push(new State(1, 1, 1, 0));
        while (!st.empty()) {
            State cur = st.pop();
            pyramid[cur.r][cur.c] = cur.value;

            int[] rPlus = {1, 0, -1};
            int[] cPlus = {0, 1, -1};
            for (int i = 0; i < 3; i++) {
                int nextDir = (cur.dir + i) % 3;
                int nextR = cur.r + rPlus[nextDir];
                int nextC = cur.c + cPlus[nextDir];
                if (isPossible(nextR, nextC, pyramid)) {
                    st.push(new State(nextR, nextC, cur.value + 1, nextDir));
                    break;
                }
            }
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                answerList.add(pyramid[i][j]);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public boolean isPossible(int r, int c, int[][] pyramid) {
        return 0 <= r && r < pyramid.length && 0 <= c && c < pyramid.length && pyramid[r][c] == 0;
    }
}
