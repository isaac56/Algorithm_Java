package programmers;

import java.util.Stack;

public class 크레인_인형뽑기_게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int n = board.length;
        int[] topIdx = new int[n];
        for(int i = 0; i < n; i++) {
            int j;
            for(j = 0; j < n; j++){
                if(board[j][i] != 0)
                    break;
            }
            topIdx[i] = j;
        }
        for(int cmd : moves) {
            int realCmd = cmd-1;
            if(topIdx[realCmd] < n){
                if(!st.empty() && board[topIdx[realCmd]][realCmd] == st.peek()){
                    st.pop();
                    answer += 2;
                }else{
                    st.push(board[topIdx[realCmd]][realCmd]);
                }
                topIdx[realCmd]++;
            }
        }
        return answer;
    }
}
