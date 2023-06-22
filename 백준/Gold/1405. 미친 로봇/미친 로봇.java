import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static double[] pos = new double[4];
    static int N;
    static boolean[][] visited;

    static double dfs(int x, int y, int n, int d, double p) {
        // 끝
        if (n == N) {
            return p;
        }
        double sum = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                sum += dfs(nx, ny, n + 1, i, p * pos[i]);
                visited[nx][ny] = false;
            }
        }


        return sum;


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[30][30];
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            pos[i] = 1.0 * Integer.parseInt(st.nextToken()) / 100;
        }
        visited[15][15] = true;
        double cnt = dfs(15, 15, 0, 0, 1.0);
        System.out.println(cnt);


    }
}
