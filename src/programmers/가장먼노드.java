package programmers;

import java.util.*;

public class 가장먼노드 {
    class Node {
        int number;
        List<Node> linked = new ArrayList<>();
        int distance;

        Node(int number) {
            this.number = number;
        }

        void addLink(Node node) {
            this.linked.add(node);
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, Node> nodes = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] link : edge) {
            int a = link[0];
            int b = link[1];
            if (!nodes.containsKey(a)) {
                nodes.put(a, new Node(a));
            }
            if (!nodes.containsKey(b)) {
                nodes.put(b, new Node(b));
            }
            nodes.get(a).addLink(nodes.get(b));
            nodes.get(b).addLink(nodes.get(a));
        }

        int maxDistance = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes.get(1));
        visited.add(1);
        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (node.distance > maxDistance) {
                answer = 1;
                maxDistance = node.distance;
            } else if (node.distance == maxDistance) {
                answer++;
            }

            for (Node linkedNode : node.linked) {
                if (!visited.contains(linkedNode.number)) {
                    linkedNode.distance = node.distance + 1;
                    queue.add(linkedNode);
                    visited.add(linkedNode.number);
                }
            }
        }

        return answer;
    }
}
