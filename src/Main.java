/**
 * Segundo trabalho pratico de ADA
 * @author Jose Romano 59241
 * @author Joao Lopes 60055
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Main class */

/**
 * The main method takes input from the user and calls the Solution class to find the number of plays needed to reach the
 * destination 'H' from the given start point. If there is no possible path, the output will be "Stuck".
 *
 * @param args An array of String objects that represents the command-line arguments passed to the program.
 * @throws IOException If an I/O error occurs.
 */

public class Main {
    private static final String STUCK = "Stuck";
    private static final char DESTINATION = 'H';
    private static int[] hole;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int rows = Integer.parseInt(in[0]);
        int cols = Integer.parseInt(in[1]);
        int numTests = Integer.parseInt(in[2]);
        char[][] map = new char[rows][cols];
        Solution solution = new Solution();

        // Initialize the map with user input.
        for (int i = 0; i < rows; i++) {
            String row = br.readLine();

            for (int j = 0; j < cols; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == DESTINATION) {
                    hole = new int[]{i, j};
                }
            }
        }

        // Iterates over the user input and calls the Solution class to find the number of plays required to reach the
        // destination point, known as "HOLE".
        for (int k = 0; k < numTests; k++) {
            String[] input = br.readLine().split(" ");
            int xInit = Integer.parseInt(input[0]) - 1;
            int yInit = Integer.parseInt(input[1]) - 1;

            if (solution.hasPath(map, new int[]{xInit, yInit}, hole))
                System.out.println(solution.getNumPlays());
            else
                System.out.println(STUCK);
        }
    }
}