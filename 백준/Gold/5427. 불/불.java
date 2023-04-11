import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Move {
        int x;
        int y;
        int cnt;
        boolean isPerson;

        public Move(int x, int y, int cnt, boolean isPerson) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isPerson = isPerson;
        }

        @Override
        public String toString() {
            return "Move{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    ", isPerson=" + isPerson +
                    '}';
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            char[][] G = new char[N][M];
            boolean[][] visited = new boolean[N][M];
            Queue<Move> Q = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    G[i][j] = str.charAt(j);
                    if (G[i][j] == '*') {
                        Q.add(new Move(i, j, 0, false));
                        visited[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (G[i][j] == '@') {
                        Q.add(new Move(i, j, 0, true));
                    }
                }
            }
            int ans = -1;

            while (!Q.isEmpty()) {
                Move cur = Q.poll();
                int x = cur.x;
                int y = cur.y;
                int cnt = cur.cnt;
                boolean isPerson = cur.isPerson;


                if (x == 0 || x == N - 1 || y == 0 || y == M - 1) {
                    if (isPerson) {
                        ans = cnt + 1;
                        break;
                    }
                }


                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M ||G[nx][ny] =='#'|| visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    Q.add(new Move(nx, ny, cnt + 1, isPerson));
                }
            } // end while

            if (ans > 0) {
                sb.append(ans).append("\n");
            } else {
                sb.append("IMPOSSIBLE").append("\n");
            }

        } // end for
        System.out.println(sb);

    }
}
