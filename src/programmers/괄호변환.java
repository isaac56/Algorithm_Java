package programmers;

public class 괄호변환 {
    boolean isPerfect(String p) {
        int result = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                result++;
            } else if (p.charAt(i) == ')') {
                result--;
            }
            if (result < 0) {
                return false;
            }
        }
        return true;
    }

    int getUIndex(String p) {
        int result = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                result++;
            } else if (p.charAt(i) == ')') {
                result--;
            }
            if (result == 0) {
                return i;
            }
        }
        return -1;
    }

    String getReversed(String p) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                builder.append(')');
            } else if (p.charAt(i) == ')') {
                builder.append('(');
            }
        }
        return builder.toString();
    }

    public String getPerfect(String p) {
        if (p.isEmpty()) {
            return p;
        }
        int uIdx = getUIndex(p);
        String u = p.substring(0, uIdx + 1);
        String v = p.substring(uIdx + 1);
        if (isPerfect(u)) {
            return u + getPerfect(v);
        } else {
            u = u.substring(1, u.length() - 1);
            return "(" + getPerfect(v) + ")" + getReversed(u);
        }
    }

    public String solution(String p) {
        return getPerfect(p);
    }
}
