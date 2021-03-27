package groom.SCF_2.P4;

import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.valueOf(br.readLine());
        String[] strings = new String[S];
        for (int i = 0; i < S; i++) {
            strings[i] = br.readLine();
        }
        int Q = Integer.valueOf(br.readLine());
        String[] queries = new String[Q];
        int[][] tables = new int[Q][];
        for (int i = 0; i < Q; i++) {
            queries[i] = br.readLine();
            tables[i] = makeTable(queries[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            int searched = 0;
            for (String string : strings) {
                if (containsUsingKMP(tables[i], string, queries[i])) {
                    searched++;
                }
            }
            System.out.println(searched);
        }
    }


    public static int[] makeTable(String string) {
        int[] table = new int[string.length()];

        int j = 0;
        for (int i = 1; i < string.length(); i++) {
            while (j > 0 && string.charAt(i) != string.charAt(j)) {
                j = table[j - 1];
            }
            if (string.charAt(i) == string.charAt(j)) {
                table[i] = ++j;
            }
        }
        return table;
    }

    public static boolean containsUsingKMP(int[] table, String string, String search) {
        int j = 0;
        for (int i = 0; i < string.length(); i++) {
            while (j > 0 && string.charAt(i) != search.charAt(j)) {
                j = table[j - 1];
            }
            if (string.charAt(i) == search.charAt(j)) {
                if (j == search.length() - 1) {
                    return true;
                } else {
                    j++;
                }
            }
        }
        return false;
    }
}
