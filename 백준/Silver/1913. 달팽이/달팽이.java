import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    static int N;
    static int[][] G;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int Q = Integer.parseInt(br.readLine());


        G = new int[N][N];
        visited = new boolean[N][N];

        // 재귀 호출로 문제를 풀면 안됨
        G[0][0] = N * N;

        int x = 0;
        int y = 0;
        int d = 0;


        for (int t = N * N - 1; t > 0; t--) {
            for (int i = 0; i < 4; i++) {
                int nd = (d + i) % 4;
                int nx = x + dx[nd];
                int ny = y + dy[nd];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || G[nx][ny] != 0) {
                    continue;
                }
                x = nx;
                y = ny;
                d = nd;
                G[x][y] = t;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();

        int qx = 0;
        int qy = 0;


        for (int[] row : G) {
            for (int n : row) {
                sb.append(n + " ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (G[i][j] == Q) {
                    qx = i + 1;
                    qy = j + 1;
                }
            }
        }
        sb.append(qx + " " + qy);
        System.out.println(sb);
    }
}
