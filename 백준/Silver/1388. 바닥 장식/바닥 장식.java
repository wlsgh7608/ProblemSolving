import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void dfs(int i, int j, boolean isRow) {
        visited[i][j] = true;
        if (!isRow) {
            if (j + 1 < M && G[i][j + 1] == '-') {
                dfs(i, j + 1, false);
            }
        } else {
            if (i + 1 < N && G[i + 1][j] == '|') {
                dfs(i + 1, j, true);
            }
        }

    }

    static boolean[][] visited;
    static char[][] G;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                G[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (G[i][j] == '-') {
                        dfs(i, j, false);
                    } else {
                        dfs(i, j, true);
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

}
