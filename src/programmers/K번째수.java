package programmers;
import java.util.*;
import java.util.stream.Collectors;

class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();
        for(int e : array) {
            list.add(e);
        }

        for(int idx = 0; idx < commands.length; idx ++) {
            int[] cmd = commands[idx];
            int i = cmd[0]-1;
            int j = cmd[1]-1;
            int k = cmd[2]-1;

            List<Integer> temp = new ArrayList<>(list.subList(i,j+1));
            Collections.sort(temp);
            answer[idx] = temp.get(k);
        }

        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int idx = 0; idx < commands.length; idx ++) {
            int[] cmd = commands[idx];
            int i = cmd[0]-1;
            int j = cmd[1]-1;
            int k = cmd[2]-1;

            int[] temp = Arrays.copyOfRange(array, i, j+1);
            Arrays.sort(temp);
            answer[idx] = temp[k];
        }

        return answer;
    }
}
