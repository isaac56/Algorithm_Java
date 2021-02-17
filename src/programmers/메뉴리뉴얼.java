package programmers;
import java.util.*;
import java.util.stream.Collectors;

public class 메뉴리뉴얼 {
    class SetMenu {
        String name;
        int order;

        SetMenu(String name){
            this.name = name;
        }

        public String toString(){
            return name + ": " + order;
        }
    }

    public String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++) {
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            orders[i] = String.valueOf(tmp);
        }

        List<String>[][] pickers = new List[11][11];
        List<String> answerList = new ArrayList<>();
        for(int c : course){
            answerList.addAll(getSet(orders, c, pickers));
        }
        Collections.sort(answerList);

        String[] answer = new String[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    List<String> getSet(String[] orders, int course, List<String>[][] pickers){
        HashMap<String, SetMenu> hm = new HashMap<>();
        List<SetMenu> menus = new ArrayList<>();
        for(String order: orders){
            int length = order.length();
            if(length < course){
                continue;
            }
            if(pickers[length][course] == null){
                pickers[length][course] = getPickers(length,course);
            }
            for(String picker : pickers[length][course]){
                String menuName = getMenu(order,picker);
                if(!hm.containsKey(menuName)) {
                    SetMenu setMenu = new SetMenu(menuName);
                    hm.put(menuName, setMenu);
                    menus.add(setMenu);
                }
                hm.get(menuName).order++;
            }
        }
        Collections.sort(menus,(a,b) -> {
            if(a.order > b.order){
                return -1;
            }else if(a.order < b.order){
                return 1;
            }else{
                return 0;
            }
        });
        // for(SetMenu menu : menus){
        //     System.out.println(menu);
        // }

        List<String> ret = new ArrayList<>();
        if(menus.size() > 0 && menus.get(0).order >= 2){
            int maxOrder = menus.get(0).order;
            for(int i = 0; i < menus.size(); i++) {
                if(menus.get(i).order == maxOrder){
                    ret.add(menus.get(i).name);
                }else{
                    break;
                }
            }
        }
        return ret;
    }

    String getMenu (String order, String picker){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < order.length(); i++) {
            if(picker.charAt(i) == '1'){
                builder.append(order.charAt(i));
            }
        }
        return builder.toString();
    }

    List<String> getPickers(int length, int course){
        char[] pickMaker = new char[length];
        for(int i = 0; i < course; i++) {
            pickMaker[i] = '1';
        }
        for(int i = course; i < length; i++) {
            pickMaker[i] = '0';
        }
        HashSet<String> pickers = new HashSet<>();
        permutation(pickMaker, 0, pickers);
        return pickers.stream().collect(Collectors.toList());
    }

    void permutation(char[] arr, int depth, HashSet<String> pickers){
        if(depth == arr.length - 1){
            pickers.add(String.valueOf(arr.clone()));
        }

        for(int i = depth; i < arr.length; i++) {
            swap(arr, i, depth);
            permutation(arr, depth + 1, pickers);
            swap(arr, i, depth);
        }
    }

    void swap(char[] arr, int i, int j){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
