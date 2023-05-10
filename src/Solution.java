/**
 * Segundo trabalho pratico de ADA
 *
 * @author Jose Romano 59241
 * @author Joao Lopes 60055
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a solution to the problem given in the assignment.
 * It provides a method "hasPath" to check whether there exists a path from a given start point to the destination point
 * where walls are represented as 'O', empty spaces as '.' and the destination/hole as 'H'.
 * The class also provides a method "getNumPlays" to retrieve the minimum number of moves required
 * to reach the destination point from the start point.
 *
 * It is used the BFS (Breadth-First-Search) algorithm to explore the maze/map and find the shortest path.
 */

public class Solution {
    private int minPlays;
    private static final int[] UP = {-1, 0};
    private static final int[] DOWN = {1, 0};
    private static final int[] LEFT = {0, -1};
    private static final int[] RIGHT = {0, 1};

    private static final char WALL = 'O';


    /**
     * Constructs a new Solution object.
     */
    public Solution() {
    }

    /**
     * Checks whether there exists a path from a given start point to a given destination point
     * in a maze represented by a 2D character array.
     *
     * @param maze         the 2D character array representing the maze.
     * @param start        the starting point represented by an int array.
     *                     The first element is the row index and the second element is the column index.
     * @param destination  the destination point also represented by an int array.
     *                     The first element is the row index and the second element is the column index.
     * @return true if there exists a path from the start point to the destination point, false otherwise.
     */

    public boolean hasPath(char[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = new int[][]{UP, DOWN, LEFT, RIGHT};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int numPlays = 0;
        boolean flag = false;


        while (!queue.isEmpty()) {
            int level_size = queue.size();
            while (level_size-- != 0) {
                int[] s = queue.poll();
                for (int[] dir : dirs) {
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];

                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && (maze[x][y] != WALL)) {
                        if (x == destination[0] && y == destination[1]) {
                            flag = true;
                            break;
                        }

                        x += dir[0];
                        y += dir[1];
                    }

                    if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) continue;

                    x -= dir[0];
                    y -= dir[1];

                    if (!visited[x][y]) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            numPlays++;
            if (flag) break;
        }
        minPlays = numPlays;
        return flag;
    }

    public int getNumPlays() {
        return minPlays;
    }
}