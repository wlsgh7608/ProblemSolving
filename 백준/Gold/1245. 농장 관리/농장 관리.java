import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] G = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int minH = 500;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(G[i][j], minH);
            }
        }
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    Queue<Loc> Q = new ArrayDeque<>();
                    Q.add(new Loc(i, j));
                    visited[i][j] = true;
                    boolean isEnd = true;
                    while (!Q.isEmpty()) {
                        Loc cur = Q.poll();
                        int x = cur.x;
                        int y = cur.y;

                        for (int k = 0; k < 8; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                                continue;
                            }

                            if (G[nx][ny] > G[x][y]) {
                                isEnd = false;
                            }

                            if (visited[nx][ny]) {
                                continue;
                            }
                            if (G[x][y] == G[nx][ny]) {
                                visited[nx][ny] = true;
                                Q.add(new Loc(nx, ny));
                            }
                        }

                    }
                    if (isEnd && G[i][j] > minH) {
                        cnt++;
                    }
                }
            }
        } // end i;
        System.out.println(cnt);
    }
}
