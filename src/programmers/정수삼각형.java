package programmers;

public class 정수삼각형 {
    public int solution(int[][] triangle) {

        int n = triangle.length;
        for(int i = 0; i < n; i++) {
            if(i > 0){
                int[] prevRow = triangle[i-1];
                int[] curRow = triangle[i];
                for(int j = 0; j < curRow.length; j++){
                    int left = 0, right = 0;
                    if(j > 0){
                        left = curRow[j] + prevRow[j-1];
                    }
                    if(j < curRow.length-1){
                        right = curRow[j] + prevRow[j];
                    }
                    curRow[j] = left > right ? left : right;
                }
            }
        }
        int answer = 0;
        int[] lastRow = triangle[n-1];
        for(int e : lastRow){
            if(answer < e){
                answer = e;
            }
        }
        return answer;
    }
}
