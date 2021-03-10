package programmers;

import java.util.*;

public class 프린터 {
    class Document {
        int idx;
        int priority;

        Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(i, priorities[i]));
        }
        Arrays.sort(priorities);
        int maxPriorityIdx = priorities.length - 1;
        int printedOrder = 0;
        while (maxPriorityIdx >= 0) {
            while (queue.element().priority < priorities[maxPriorityIdx]) {
                queue.add(queue.remove());
            }
            printedOrder++;
            maxPriorityIdx--;
            Document printed = queue.remove();
            if (printed.idx == location) {
                return printedOrder;
            }
        }

        int answer = 0;
        return answer;
    }
}
