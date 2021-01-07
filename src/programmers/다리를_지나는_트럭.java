package programmers;
import java.util.*;

public class 다리를_지나는_트럭 {
    private class Truck{
        public int enterTime;
        public int weight;

        public Truck(int time, int weight) {
            this.enterTime = time;
            this.weight = weight;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int currentT = 0;
        int currentW = 0;
        Queue<Truck> que = new LinkedList<>();
        for(int truckWeight : truck_weights) {
            currentT++;
            while(!que.isEmpty() && que.element().enterTime + bridge_length <= currentT) {
                currentW -= que.element().weight;
                que.remove();
            }
            while(currentW + truckWeight > weight) {
                currentT = que.element().enterTime + bridge_length;
                currentW -= que.element().weight;
                que.remove();
            }
            que.add(new Truck(currentT, truckWeight));
            currentW += truckWeight;
        }
        while(!que.isEmpty()){
            currentT = que.element().enterTime + bridge_length;
            que.remove();
        }

        return currentT;
    }
}