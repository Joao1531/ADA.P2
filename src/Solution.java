import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private char[][] map;
    private boolean[][] visited;
    private Queue<int[]> q;
    private int numPlays;
    int[][] dirs;


    public Solution(char[][] map) {
        q = new LinkedList<>();
        this.map = map;
        visited = new boolean[map.length][map[0].length];
        numPlays = 0;
        dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    }

    public boolean hasPath(int xInit, int yInit) {
        numPlays = 0;
        int[] start = {xInit, yInit};
        visited[start[0]][start[1]] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                while (x >= 0 && y >= 0 && x < map.length && y < map[0].length && map[x][y] == '.') {
                    x += dir[0];
                    y += dir[1];
                }
                numPlays++;
                x -= dir[0];
                y -= dir[1];
                //verificar se ja chegamos ao H
                if (map[curr[0]][curr[1]] == 'H'){
                    return true;
                }

                if (!visited[x][y]) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

    public int getNumPlays() {
        return numPlays;
    }
}

