package programmers;

import java.util.*;

public class 후보키 {
    class State {
        Set<Integer> currentKey;
        int lastAdded;

        State(Set<Integer> currentKey, int lastAdded) {
            this.currentKey = currentKey;
            this.lastAdded = lastAdded;
        }
    }

    public int solution(String[][] relation) {
        int columnCnt = relation[0].length;

        Set<Set<Integer>> answers = new HashSet();
        Queue<State> bfs = new LinkedList<>();
        bfs.add(new State(new HashSet<>(), -1));
        while (!bfs.isEmpty()) {
            State cur = bfs.remove();
            Set<Integer> curKey = cur.currentKey;
            int lastAdded = cur.lastAdded;

            if (answers.contains(curKey)) {
                continue;
            }

            if (isMinimized(answers, curKey) && isUnique(relation, curKey)) {
                answers.add(curKey);
                continue;
            }

            for (int i = lastAdded + 1; i < columnCnt; i++) {
                Set<Integer> nextKey = new HashSet<>(curKey);
                nextKey.add(i);
                bfs.add(new State(nextKey, i));
            }
        }

        return answers.size();
    }

    public boolean isMinimized(Set<Set<Integer>> answers, Set<Integer> key) {
        for (Set<Integer> answer : answers) {
            if (key.containsAll(answer)) {
                return false;
            }
        }
        return true;
    }

    public boolean isUnique(String[][] relation, Set<Integer> key) {
        Set<String> hs = new HashSet<>();
        for (String[] row : relation) {
            String rowString = "";
            for (int col : key) {
                rowString += row[col];
            }
            if (hs.contains(rowString)) {
                return false;
            }
            hs.add(rowString);
        }
        return true;
    }
}
