import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class FreeNode {
        int x;
        int y;
        int l;

        public FreeNode(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public FreeNode(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
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

            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            char[][] G = new char[R][C];
            for (int i = 0; i < R; i++) {
                G[i] = br.readLine().toCharArray();
            }

            boolean[][] visited = new boolean[R][C];
            Queue<FreeNode> Q = new ArrayDeque<>();

            here:
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (G[i][j] == '.') {
                        visited[i][j] = true;
                        Q.add(new FreeNode(i, j));
                        break here;

                    }
                }
            }
            int lastX = -1;
            int lastY = -1;

            while (!Q.isEmpty()) {
                FreeNode cur = Q.poll();
                lastX = cur.x;
                lastY = cur.y;

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || G[nx][ny] == '#') {
                        continue;
                    }
                    visited[nx][ny] = true;
                    Q.add(new FreeNode(nx, ny));
                }
            }
            visited = new boolean[R][C];
            Q.add(new FreeNode(lastX, lastY, 0));
            visited[lastX][lastY] = true;
            int maxLength = 0;
            while (!Q.isEmpty()) {
                FreeNode cur = Q.poll();
                maxLength = cur.l;

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || G[nx][ny] == '#') {
                        continue;
                    }
                    visited[nx][ny] = true;
                    Q.add(new FreeNode(nx, ny, cur.l + 1));

                }
            }
            sb.append("Maximum rope length is " + maxLength + ".").append("\n");
        }
        System.out.println(sb);


    }
}

