import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] G = new char[H][W];
        int[][] ans = new int[H][W];

        for (int i = 0; i < H; i++) {
            G[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < H; i++) {
            int cloud = -1;
            for (int j = 0; j < W; j++) {
                if (cloud >= 0) {
                    cloud++;
                }
                if (G[i][j] == 'c') {
                    cloud = 0;
                }
                ans[i][j] = cloud;
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
