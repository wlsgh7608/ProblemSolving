import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int answer = -40_000;
    static int[][] visited;
    static int[][] G;


    static void visitCheck(int x, int y, int value) {
        int[] dx = {-1, 1, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0};


        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            visited[nx][ny] += value;

        }
    }

    static void dfs(int x, int y, int depth, int sum) {

        if (depth == K) {
            answer = Math.max(answer, sum);
            return;
        }


        for (int i = x; i < N; i++) {
            for (int j = (i == x ? y : 0); j < M; j++) {
                if (visited[i][j] > 0) continue;
                visitCheck(i, j, 1);
                dfs(i, j, depth + 1, sum + G[i][j]);
                visitCheck(i, j, -1);
            }
        }


    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        G = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0,0,0);
        System.out.println(answer);


    }
}
