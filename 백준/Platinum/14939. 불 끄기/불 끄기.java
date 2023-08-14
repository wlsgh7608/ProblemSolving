import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static void switchOn(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10) {
                continue;
            }
            newG[nx][ny] = !newG[nx][ny];
        }
    }

    static boolean[][] newG;

    static int[] dx = {-1, 0, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0, 0};
    static int N = 10;
    static int minCnt = 100_000;

    static void dfs(int depth, int cnt) {
        if (depth == 10) {
            for (int i = 0; i < N; i++) {
                if (newG[N - 1][i]) {
                    return;
                }
            }
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (newG[depth - 1][i]) {
                switchOn(depth, i);
                cnt++;
            }
        }
        dfs(depth + 1, cnt);

    }

    static boolean[][] copy(boolean[][] G) {
        boolean[][] newG = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            newG[i] = G[i].clone();
        }
        return newG;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] G = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            String row = br.readLine();
            for (int j = 0; j < 10; j++) {
                if (row.charAt(j) == '#') {
                    G[i][j] = false;
                } else {
                    G[i][j] = true;
                }
            }
        }
        // end input

        // 첫 번째 가능한 경우
        for (int i = 0; i < (1 << N); i++) {
            newG = copy(G);
            int cnt = Integer.bitCount(i);

            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    switchOn(0, j);
                }
            }
            dfs(1, cnt);
        }
        if (minCnt < 100_000) {
            System.out.println(minCnt);
        } else {
            System.out.println(-1);
        }

    }


}

