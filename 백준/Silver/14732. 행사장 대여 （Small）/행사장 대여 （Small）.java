import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] G = new boolean[500][500];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int j = a; j < c; j++) {
                for (int k = b; k < d; k++) {
                    G[j][k] = true;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                if (G[i][j]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
