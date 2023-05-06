import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int rows = Integer.parseInt(in[0]);
        int cols = Integer.parseInt(in[1]);
        int numTests = Integer.parseInt(in[2]);
        char[][] map = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String row = br.readLine();
            for (int j = 0; j < cols; j++)
                map[i][j] = row.charAt(j);
        }
        for (int k = 0; k < numTests; k++) {
            String[] input = br.readLine().split(" ");
            int xInit = Integer.parseInt(input[0]);
            int yInit = Integer.parseInt(input[1]);

        }
    }
}