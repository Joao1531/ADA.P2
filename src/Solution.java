import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private char[][] map;
    private boolean[][] visited;
    private Queue<int[]> q;
    private int numPlays;
    int[][] dirs;
    int[] destination;


    public Solution(char[][] map, int xH, int yH) {
        this.map = map;
        destination = new int[]{xH, yH};
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    }

    public boolean hasPath(int xInit, int yInit) {
        //Vars
        numPlays = 0;
        int[] start = {xInit, yInit};
        int n = map.length;
        int m = map[0].length;
        //Structures
        q = new LinkedList<>();
        visited = new boolean[n][m];
        //Fill structures
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {

                int x = curr[0];
                int y = curr[1];

                while (x + dir[0] >= 0 &&
                        y + dir[1] >= 0 &&
                        x + dir[0] < n &&
                        y + dir[1] < m &&
                        map[x + dir[0]][y + dir[1]] != 'O' && map[x + dir[0]][y + dir[1]] != 'H') {
                    x += dir[0];
                    y += dir[1];
                }
                //Fui contra uma parede ou sai do mapa
                if (!visited[x][y]) {
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }

                numPlays++;

                //verificar se ja chegamos ao H
                if (curr[0] == destination[0] && curr[1] == destination[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getNumPlays() {
        return numPlays;
    }
}

