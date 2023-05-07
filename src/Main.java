import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String STUCK = "Stuck";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        /* DISASSEMBLE INPUT */
        int rows = Integer.parseInt(in[0]);
        int cols = Integer.parseInt(in[1]);
        int numTests = Integer.parseInt(in[2]);
        /* CREATE STRUCTS */
        int[][] map = new int[rows][cols];
        int xH = Integer.MAX_VALUE, yH = Integer.MAX_VALUE;

        /* RECEBER LINHAS DO MAPA DE INPUT E CONVERTER PARA MAPA DE INTS PARA FACILITAR */
        for (int i = 0; i < rows; i++) {
            //RECEBE LINHA
            String row = br.readLine();


            for (int j = 0; j < cols; j++) {
                //POR CADA INDEX CONVERTE '.' -> 0 || 'O' -> 1 || 'H'-> 2
                if (row.charAt(j) == '.') map[i][j] = 0;
                else if (row.charAt(j) == 'O') map[i][j] = 1;
                else if (row.charAt(j) == 'H') map[i][j] = 2;

                //GUARDAR COORDENADAS NO HOLE
                if (map[i][j] == 2) {
                    xH = i - 1;
                    yH = j - 1;
                }
            }
        }
        Solution solution = new Solution(map);
        //Print do mapa
        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }*/

        //for (int k = 0; k < numTests; k++) {
        String[] input = br.readLine().split(" ");

        int xInit = Integer.parseInt(input[0]) - 1;
        int yInit = Integer.parseInt(input[1]) - 1;

        if (solution.hasPath(new int[]{xInit, yInit}))
            System.out.println("TRUE");
        else
            System.out.println(STUCK);

        //}
    }
}