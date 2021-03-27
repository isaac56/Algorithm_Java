package groom.SCF_2.P2;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> hm = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[][] actualLink = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] link = br.readLine().split(" ");
            String city1 = link[0];
            String city2 = link[1];
            int cost = Integer.valueOf(link[2]);
            if (!hm.containsKey(city1)) {
                hm.put(city1, hm.size());
            }
            if (!hm.containsKey((city2))) {
                hm.put(city2, hm.size());
            }
            actualLink[i][0] = hm.get(city1);
            actualLink[i][1] = hm.get(city2);
            actualLink[i][2] = cost;
        }

        new Main().solve(actualLink, hm.size());
    }

    public void solve(int[][] links, int nodeNum) {
        Arrays.sort(links, (a, b) -> {
            if (a[2] < b[2]) {
                return -1;
            } else if (a[2] > b[2]) {
                return 1;
            } else {
                return 0;
            }
        });
        int[] parent = new int[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int linkedNum = 0;
        for (int i = 0; i < links.length; i++) {
            int p1 = getParent(parent, links[i][0]);
            int p2 = getParent(parent, links[i][1]);
            if (p1 != p2) {
                parent[p2] = p1;
                totalCost += links[i][2];
                linkedNum++;
            }
            if (linkedNum == nodeNum - 1) {
                break;
            }
        }
        System.out.println(totalCost);
    }

    public int getParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = getParent(parent, parent[node]);
    }
}
