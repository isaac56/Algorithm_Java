package programmers;
import java.util.*;
public class 소수찾기 {
    public boolean isPrime(long num){
        if(num == 0 || num == 1)
            return false;

        for(long i = 2; i <= (long)Math.sqrt((double)num); i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }

    public void permutation(StringBuilder builder, int depth, HashSet<Long> candiSet) {
        if(depth == builder.length() - 1) {
            for(int i = 0; i < builder.length(); i++) {
                candiSet.add(Long.valueOf(builder.substring(i)));
            }
            return;
        }

        for(int i = 0; i < builder.length(); i++) {
            swap(builder, depth, i);
            permutation(builder, depth+1, candiSet);
            swap(builder, depth, i);
        }
    }

    public void swap(StringBuilder builder, int i, int j) {
        char temp = builder.charAt(i);
        builder.setCharAt(i, builder.charAt(j));
        builder.setCharAt(j, temp);
    }

    public int solution(String numbers) {
        HashSet<Long> candiSet = new HashSet<>();
        permutation(new StringBuilder(numbers), 0, candiSet);
        int answer = 0;
        for(Long e : candiSet){
            System.out.println(e);
            if(isPrime(e))
                answer++;
        }

        return answer;
    }
}
