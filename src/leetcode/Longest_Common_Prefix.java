package leetcode;

public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        StringBuilder builder = new StringBuilder();
        String first = strs[0];
        for(int i = 0; i < first.length(); i++) {
            char prefix = first.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].length()-1 < i || prefix != strs[j].charAt(i))
                {
                    return builder.toString();
                }
            }
            builder.append(prefix);
        }
        return builder.toString();
    }
}
