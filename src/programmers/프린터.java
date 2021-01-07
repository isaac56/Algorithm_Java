package programmers;
import java.util.*;
public class 프린터 {
    class Document {
        int location;
        int priority;
        public Document (int loc, int p) {
            this.location = loc;
            this.priority = p;
        }
    }

    public int solution(int[] priorities, int location) {
        int[] priorityNum = new int[10];
        int maxPriority = 0;
        Queue<Document> waiting = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            waiting.add(new Document(i, priorities[i]));
            priorityNum[priorities[i]]++;
            if(maxPriority < priorities[i]) maxPriority = priorities[i];
        }

        int order = 0;
        while(!waiting.isEmpty()) {
            if(maxPriority > waiting.element().priority)
            {
                waiting.add(waiting.element());
                waiting.remove();
            }
            else {
                order++;
                if(waiting.element().location == location)
                    return order;

                priorityNum[waiting.element().priority]--;
                while(priorityNum[maxPriority] == 0) {
                    maxPriority--;
                }
                waiting.remove();
            }
        }

        int answer = 0;
        return answer;
    }
}
