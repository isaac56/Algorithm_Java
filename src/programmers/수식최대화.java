package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 수식최대화 {
    public long solution(String expression) {
        Stack<String> st = new Stack<>();
        int prev = 0;
        Set<String> operatorSet = new HashSet<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
                st.push(expression.substring(prev, i));
                st.push(expression.substring(i, i + 1));
                operatorSet.add(expression.substring(i, i + 1));
                prev = i + 1;
            }
            if (i == expression.length() - 1) {
                st.push(expression.substring(prev));
            }
        }

        List<String> operatorList = operatorSet.stream().collect(Collectors.toList());
        Set<List<String>> result = new HashSet<>();
        permutation(operatorList, 0, result);

        long max = 0;
        for (List<String> order : result) {
            max = Math.max(max, Math.abs(calculate(order, st)));
        }

        return max;
    }

    public long calculate(List<String> operators, Stack<String> st) {
        Stack<String> currentStack = st;
        for (String operator : operators) {
            Stack<String> nextStack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < currentStack.size(); i++) {
                if (currentStack.get(i).equals(operator)) {
                    flag = true;
                } else if (flag) {
                    Long n1 = Long.valueOf(nextStack.pop());
                    Long n2 = Long.valueOf(currentStack.get(i));
                    if (operator.equals("+")) {
                        nextStack.push(String.valueOf(n1 + n2));
                    } else if (operator.equals("-")) {
                        nextStack.push(String.valueOf(n1 - n2));
                    } else {
                        nextStack.push(String.valueOf(n1 * n2));
                    }
                    flag = false;
                } else {
                    nextStack.push(currentStack.get(i));
                }
            }
            currentStack = nextStack;
        }

//        System.out.println("남은 사이즈: " + currentStack.size());
        return Long.valueOf(currentStack.pop());
    }

    public void permutation(List<String> operatorList, int depth, Set<List<String>> result) {
        if (depth == operatorList.size() - 1) {
            result.add(new ArrayList<String>(operatorList));
        }

        for (int i = depth; i < operatorList.size(); i++) {
            swap(depth, i, operatorList);
            permutation(operatorList, depth + 1, result);
            swap(depth, i, operatorList);
        }
    }

    public void swap(int i, int j, List<String> list) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
