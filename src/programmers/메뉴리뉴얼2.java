package programmers;

import java.util.*;

public class 메뉴리뉴얼2 {
    class Course {
        String name;
        int orderedNum;

        Course(String name, int orderedNum) {
            this.name = name;
            this.orderedNum = orderedNum;
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        //주문 목록들을 알파벳 순으로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        //코스 개수의 조합 주문 횟수를 세서 정답에 넣는다.
        for (int r : course) {
            Map<String, Course> hm = new HashMap<>();

            for (String order : orders) {
                int n = order.length();
                if (order.length() >= r) {
                    countCourse(order, getCombination(n, r), hm);
                }
            }
            List<Course> courses = new ArrayList<>();
            for (Course c : hm.values()) {
                if (c.orderedNum >= 2) {
                    courses.add(c);
                }
            }
            Collections.sort(courses, (a, b) -> {
                if (a.orderedNum > b.orderedNum) {
                    return -1;
                } else if (a.orderedNum < b.orderedNum) {
                    return 1;
                } else {
                    return 0;
                }
            });
            if (courses.size() > 0) {
                int max = courses.get(0).orderedNum;
                for (Course c : courses) {
                    if (c.orderedNum == max) {
                        answerList.add(c.name);
                    }
                }
            }

        }
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    void countCourse(String order, List<int[]> combination, Map<String, Course> hm) {
        for (int[] picker : combination) {
            String courseName = getCourseName(order, picker);
            if (!hm.containsKey(courseName)) {
                hm.put(courseName, new Course(courseName, 0));
            }
            hm.get(courseName).orderedNum++;
        }
    }

    String getCourseName(String order, int[] picker) {
        String name = "";
        for (int i = 0; i < order.length(); i++) {
            if (picker[i] == 1) {
                name += order.charAt(i);
            }
        }
        return name;
    }

    public List<int[]> getCombination(int n, int r) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) == r) {
                int[] add = new int[n];
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        add[j] = 1;
                    }
                }
                list.add(add);
            }
        }
        return list;
    }
}
