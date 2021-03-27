package groom.SCF_2.P3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NQ = br.readLine().split(" ");
        int N = Integer.valueOf(NQ[0]);
        int Q = Integer.valueOf(NQ[1]);
        int[][] structure = new int[N - 1][2];
        for (int i = 0; i < N - 1; i++) {
            String[] parentChild = br.readLine().split(" ");
            structure[i][0] = Integer.valueOf(parentChild[0]);
            structure[i][1] = Integer.valueOf(parentChild[1]);
        }
        int[][] question = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            String[] parentChild = br.readLine().split(" ");
            question[i][0] = Integer.valueOf(parentChild[0]);
            question[i][1] = Integer.valueOf(parentChild[1]);
        }

        new Main().solve(N, structure, question);
    }

    void solve(int N, int[][] structure, int[][] question) {
//        System.out.println("N: " + N);
//        System.out.println("structure start!!!");
//        for (int[] s : structure) {
//            System.out.println(s[0] + ", " + s[1]);
//        }
//        System.out.println("question start!!!");
//        for (int[] q : question) {
//            System.out.println(q[0] + ", " + q[1]);
//        }
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i, null, N);
        }
        for (int[] s : structure) {
            int parent = s[0];
            int child = s[1];
            nodes[child].parent = nodes[parent];
        }

        for (int[] q : question) {
            int parent = q[0];
            int child = q[1];
            boolean result = nodes[child].isParent(parent);
            if (result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    class Node {
        int name;
        Node parent;
        boolean[] isParent;
        Node maxSearchedNode;
        boolean fullSearched;

        Node(int name, Node parent, int N) {
            this.name = name;
            this.parent = parent;
            isParent = new boolean[N + 1];
        }

        boolean isParent(int parent) {
            if (isParent[parent] == true) {
                return true;
            }
            if (isParent[parent] == false && fullSearched == true) {
                return false;
            }

            Node node = maxSearchedNode == null ? this.parent : maxSearchedNode;
            while (node != null) {
                isParent[node.name] = true;
                if (node.name == parent) {
                    maxSearchedNode = node;
                    if (node.parent == null) {
                        fullSearched = true;
                    }
                    return true;
                }
                node = node.parent;
            }
            fullSearched = true;
            return false;
        }
    }
}
