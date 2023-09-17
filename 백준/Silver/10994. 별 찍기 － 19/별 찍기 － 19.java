import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static void dfs(int idx) {
        if (idx == N) {
            G[X][Y] = true;
            return;
        }


        for (int i = 0; i <= 4 * idx; i++) {
            G[X - idx * 2][Y - idx * 2 + i] = true;
        }

        for (int i = 0; i <= 4 * idx; i++) {
            G[X + idx * 2][Y - idx * 2 + i] = true;
        }
        for (int i = 0; i <= 4 * idx; i++) {
            G[X - idx * 2 + i][Y - idx * 2] = true;
        }
        for (int i = 0; i <= 4 * idx; i++) {
            G[X - idx * 2 + i][Y + idx * 2] = true;
        }
        dfs(idx + 1);


    }

    static int N;
    static boolean[][] G;
    static int X, Y;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        G = new boolean[4 * (N - 1) + 1][4 * (N - 1) + 1];
        X = 2 * (N - 1);
        Y = 2 * (N - 1);
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : G) {
            for(boolean isTrue : row){
                if(isTrue){
                    sb.append("*");
                }
                else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
