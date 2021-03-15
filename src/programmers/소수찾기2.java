package programmers;

import java.util.*;

public class 소수찾기2 {
    boolean isPrime(int candidate) {
        if (candidate < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(candidate); i++) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }

    void permutation(char[] arr, int depth, Set<Integer> set) {
        if (depth == arr.length) {
            String s = String.valueOf(arr);
            for (int i = 1; i <= s.length(); i++) {
                set.add(Integer.valueOf(s.substring(0, i)));
            }
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, set);
            swap(arr, depth, i);
        }
    }

    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int solution(String numbers) {
        char[] charArr = numbers.toCharArray();
        Set<Integer> hs = new HashSet<>();
        permutation(charArr, 0, hs);
        int answer = 0;
        for (int candidate : hs) {
            if (isPrime(candidate)) {
                answer++;
            }
        }
        return answer;
    }
}
