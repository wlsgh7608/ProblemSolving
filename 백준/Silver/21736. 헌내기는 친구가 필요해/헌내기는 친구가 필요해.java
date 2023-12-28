import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] G = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Point> Q = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                G[i][j] = line.charAt(j);
                if (G[i][j] == 'I') {
                    visited[i][j] = true;
                    Q.add(new Point(i, j));
                }
            }
        }

        int[] dx = {-1, 1, 0, 0,};
        int[] dy = {0, 0, -1, 1};

        int cnt = 0;
        while (!Q.isEmpty()) {
            Point cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || G[nx][ny] == 'X') {
                    continue;
                }
                if (G[nx][ny] == 'P') {
                    cnt++;
                }
                visited[nx][ny] = true;
                Q.add(new Point(nx, ny));
            }
        }
        if (cnt > 0) {
            System.out.println(cnt);
        } else {
            System.out.println("TT");
        }

    }
}
