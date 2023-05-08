import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String STUCK = "Stuck";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int rows = Integer.parseInt(in[0]);
        int cols = Integer.parseInt(in[1]);
        int numTests = Integer.parseInt(in[2]);
        int[][] map = new int[rows][cols];
        int xH = Integer.MAX_VALUE, yH = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            String row = br.readLine();

            for (int j = 0; j < cols; j++) {
                if (row.charAt(j) == '.') map[i][j] = 0;
                else if (row.charAt(j) == 'O') map[i][j] = 1;
                else if (row.charAt(j) == 'H') map[i][j] = 2;

                //GUARDAR COORDENADAS NO HOLE
                if (map[i][j] == 2) {
                    xH = i;
                    yH = j;
                }
            }
        }
        Solution solution = new Solution();


        for (int k = 0; k < numTests; k++) {
            String[] input = br.readLine().split(" ");


            int xInit = Integer.parseInt(input[0]) - 1;
            int yInit = Integer.parseInt(input[1]) - 1;
            if (solution.hasPath(map, new int[]{xInit, yInit}, new int[]{xH, yH}))
                System.out.println(solution.getNumPlays());
            else
                System.out.println(STUCK);
        }
    }
}