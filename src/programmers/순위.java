package programmers;

import java.util.*;

public class 순위 {
    class Node {
        int name;
        Set<Node> upSet = new HashSet<>();
        Set<Node> downSet = new HashSet<>();

        Node(int name) {
            this.name = name;
        }

        int getTotal() {
            return upSet.size() + downSet.size();
        }

        void addUp(Node node) {
            this.upSet.addAll(node.upSet);
            this.upSet.add(node);
            for (Node temp : this.downSet) {
                temp.upSet.addAll(node.upSet);
                temp.upSet.add(node);
            }
            
            node.downSet.addAll(this.downSet);
            node.downSet.add(this);
            for (Node temp : node.upSet) {
                temp.downSet.addAll(this.downSet);
                temp.downSet.add(this);
            }
        }
    }

    public int solution(int n, int[][] results) {
        Map<Integer, Node> hm = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hm.put(i, new Node(i));
        }
        for (int[] result : results) {
            Node upNode = hm.get(result[0]);
            Node downNode = hm.get(result[1]);
            downNode.addUp(upNode);
        }
        int answer = 0;
        for (Node node : hm.values()) {
            if (node.getTotal() == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
