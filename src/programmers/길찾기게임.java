package programmers;

import java.util.*;

public class 길찾기게임 {
    class Node{
        public int value;
        public int x, y;
        Node left, right;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        public void addNode(Node node) {
            if(node.x < this.x){
                if(this.left == null)
                    this.left = node;
                else
                    left.addNode(node);
            }
            else {
                if(this.right == null)
                    this.right = node;
                else
                    right.addNode(node);
            }
        }
    }

    public void preOrder(List<Integer> list, Node node){
        list.add(node.value);
        if(node.left != null)
            preOrder(list, node.left);
        if(node.right != null)
            preOrder(list, node.right);
    }

    public void postOrder(List<Integer> list, Node node){
        if(node.left != null) {
            postOrder(list, node.left);
        }
        if(node.right != null) {
            postOrder(list, node.right);
        }
        list.add(node.value);
    }

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y > o2.y)
                    return -1;
                else if(o1.y < o2.y)
                    return 1;
                else
                    return 0;
            }
        });
        Node root = nodeList.get(0);
        for(int i = 1; i < nodeList.size(); i++){
            root.addNode(nodeList.get(i));
        }

        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        preOrder(preList, root);
        postOrder(postList, root);
        int[][] answer = new int[2][];
        answer[0] = preList.stream().mapToInt(x -> x.intValue()).toArray();
        answer[1] = postList.stream().mapToInt(x -> x.intValue()).toArray();
        return answer;
    }
}
