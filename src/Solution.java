import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int numPlays;
    private boolean flag;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        numPlays = 0;
        flag = false;

        while (!queue.isEmpty()) {
            int level_size = queue.size();
            while (level_size-- != 0) {
                int[] s = queue.poll();
                // The furthest point in four directions
                for (int[] dir : dirs) {
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];
                    //System.out.println("Estas são as coordenadas do nó da queue + as coordenadas da direcao " + x + "<->" + y);

                    // move Furthest straight-line distance
                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && (maze[x][y] != 1)) {
                        if (maze[x][y] == 2) {
                            flag = true;
                            break;
                        }
                        x += dir[0];
                        y += dir[1];
                    }
                    x -= dir[0];
                    y -= dir[1];
                    // Furthest (x,y)
                    if (!visited[x][y]) {
                        //System.out.println(x + " - " + y);
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            numPlays++;
            if (flag) break;
            //System.out.println("curr level: " + numPlays);
        }
        return flag;
    }

    public int getNumPlays() {
        return numPlays;
    }
}