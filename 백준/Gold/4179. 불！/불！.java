import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Loc {
        int x;
        int y;
        int t;
        boolean isHuman;

        public Loc(int x, int y, int t, boolean isHuman) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.isHuman = isHuman;
        }
    }

    static boolean isEnd(int x, int y) {
        if (x == 0 || x == N - 1 || y == 0 || y == M - 1) {
            return true;
        }
        return false;
    }

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        char[][] G = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Loc> Q = new ArrayDeque<>();
        int hx = -1;
        int hy = -1;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                G[i][j] = input.charAt(j);
                if (G[i][j] == 'J') {
                    hx = i;
                    hy = j;
                    visited[i][j] = true;
                } else if (G[i][j] == 'F') {
                    Q.add(new Loc(i, j, 1, false));
                    visited[i][j] = true;
                }
            }
        }
        Q.add(new Loc(hx, hy, 1, true));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int cnt = -1;

        while (!Q.isEmpty()) {
            Loc cur = Q.poll();
            int x = cur.x;
            int y = cur.y;

            if (cur.isHuman && isEnd(x, y)) {
                cnt = cur.t;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx == N || ny == M || G[nx][ny] == '#' || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                Q.add(new Loc(nx, ny, cur.t + 1, cur.isHuman));
            }

        }
        if (cnt < 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(cnt);
        }
    }
}
