package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 리틀프렌즈사천성 {
    class Location {
        int row;
        int col;

        Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public String solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        Map<Character, List<Location>> characterLocation = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);
                if ('A' <= map[i][j] && map[i][j] <= 'Z') {
                    if (!characterLocation.containsKey(map[i][j])) {
                        characterLocation.put(map[i][j], new ArrayList<>());
                    }
                    characterLocation.get(map[i][j]).add(new Location(i, j));
                }
            }
        }

        List<Character> characters = characterLocation.keySet().stream().sorted().collect(Collectors.toList());
        boolean[] visited = new boolean[characters.size()];

        String answer = dfs(map, characterLocation, new StringBuilder(), characters, visited);

        if (answer == null) {
            answer = "IMPOSSIBLE";
        }
        return answer;
    }

    private String dfs(char[][] map, Map<Character, List<Location>> characterLocation, StringBuilder tiles,
                       List<Character> characters, boolean[] visited) {
        if (tiles.length() == characters.size()) {
            return tiles.toString();
        }

        for (int i = 0; i < characters.size(); i++) {
            char character = characters.get(i);
            Location l1 = characterLocation.get(character).get(0);
            Location l2 = characterLocation.get(character).get(1);
            if (visited[i] == false && isPossible(map, l1, l2)) {
                visited[i] = true;
                map[l1.row][l1.col] = '.';
                map[l2.row][l2.col] = '.';
                tiles.append(character);

                String result = dfs(map, characterLocation, tiles, characters, visited);
                if (result != null) {
                    return result;
                }

                tiles.setLength(tiles.length() - 1);
                map[l1.row][l1.col] = character;
                map[l2.row][l2.col] = character;
                visited[i] = false;
            }
        }

        return null;
    }

    private boolean isPossible(char[][] map, Location location1, Location location2) {
        if (location1.row == location2.row || location1.col == location2.col) {
            return isStraightPossible(map, location1, location2);
        }

        if (isStopByPossible(map, location1, location2, new Location(location1.row, location2.col))) {
            return true;
        }

        if (isStopByPossible(map, location1, location2, new Location(location2.row, location1.col))) {
            return true;
        }

        return false;
    }

    private boolean isStopByPossible(char[][] map, Location location1, Location location2, Location stopBy) {
        return map[stopBy.row][stopBy.col] == '.' && isStraightPossible(map, location1, stopBy) && isStraightPossible(map, location2, stopBy);
    }

    private boolean isStraightPossible(char[][] map, Location location1, Location location2) {
        if (location1.row == location2.row) {
            int minCol = location1.col < location2.col ? location1.col : location2.col;
            int maxCol = location1.col > location2.col ? location1.col : location2.col;
            for (int col = minCol + 1; col < maxCol; col++) {
                if (map[location1.row][col] != '.') {
                    return false;
                }
            }
            return true;
        }

        if (location1.col == location2.col) {
            int minRow = location1.row < location2.row ? location1.row : location2.row;
            int maxRow = location1.row > location2.row ? location1.row : location2.row;
            for (int row = minRow + 1; row < maxRow; row++) {
                if (map[row][location1.col] != '.') {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
