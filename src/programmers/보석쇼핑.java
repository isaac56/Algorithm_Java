package programmers;
import java.util.*;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        Set<String> hs = new HashSet<String>();
        Map<String, Integer> hm = new HashMap<>();
        for(String gem: gems) {
            hs.add(gem);
        }
        int totalNum = hs.size();
        int minSize = gems.length+1;
        int start = 0, end = 0;

        int[] answer = new int[2];
        while(end < gems.length){
            hm.put(gems[end], hm.getOrDefault(gems[end],0)+1);
            while(hm.get(gems[start]) > 1) {
                hm.put(gems[start], hm.get(gems[start])-1);
                start++;
            }
            if(hm.size() == totalNum && end-start+1 < minSize) {
                minSize = end-start+1;
                answer[0] = start+1;
                answer[1] = end+1;
            }
            end++;
        }

        return answer;
    }

    //효율성에서 실패한 답안
//    public int[] solution(String[] gems){
//        Set<String> hs = new HashSet<>();
//        for(String gem : gems)
//            hs.add(gem);
//        int max = gems.length;
//        int min = hs.size();
//        int mid = (max + min) / 2;
//
//        int[] answer = null;
//        while(min <= max){
//            int[] curAnswer = getAnswer(gems, mid, hs.size());
//            if(curAnswer != null){
//                max = mid - 1;
//                mid = (max + mid) / 2;
//                answer = curAnswer;
//            }else {
//                min = mid + 1;
//                mid = (max + min) / 2;
//            }
//        }
//
//        return answer;
//    }
//
//    public int[] getAnswer(String[] gems, int length, int gemNum){
//        Map<String, Integer> hm = new HashMap<>();
//        for(int i = 0; i < length; i++) {
//            hm.put(gems[i],hm.getOrDefault(gems[i],0) + 1);
//        }
//        if(hm.size() == gemNum){
//            return new int[]{1, length};
//        }
//
//        for(int i = length; i < gems.length; i++) {
//            String toRemove = gems[i-length];
//            hm.put(toRemove, hm.get(toRemove)-1);
//            if(hm.get(toRemove) == 0){
//                hm.remove(toRemove);
//            }
//
//            String toAdd = gems[i];
//            hm.put(toAdd,hm.getOrDefault(toAdd,0) + 1);
//
//            if(hm.size() == gemNum){
//                return new int[]{ (i-length+1) + 1, (i) + 1};
//            }
//        }
//        return null;
//    }
}
