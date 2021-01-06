package programmers;
import java.util.*;

public class 주식가격 {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            while(!st.empty() && prices[st.peek()] > price) {
                int topIdx = st.peek();
                st.pop();
                answer[topIdx] = i - topIdx;
            }
            st.push(i);
        }

        while(!st.empty()) {
            int topIdx = st.peek();
            st.pop();
            answer[topIdx] = prices.length - 1 - topIdx;
        }

        return answer;
    }
}
