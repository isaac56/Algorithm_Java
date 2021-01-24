package programmers;

public class 타겟넘버 {
    public void dfs(int[] answer, int[] numbers, int target, int sum, int k){
        if(k == numbers.length){
            if(sum == target)
                answer[0]++;
            return;
        }

        dfs(answer, numbers, target, sum + numbers[k], k+1);
        dfs(answer, numbers, target, sum - numbers[k], k+1);
    }

    public int solution(int[] numbers, int target) {
        int[] answer = new int[]{0};
        dfs(answer, numbers, target, 0, 0);
        return answer[0];
    }
}
