import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Route {
        int x;
        int y;
        int z;
        int t;

        public Route(int x, int y, int z, int t) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.t = t;
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());


            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            char[][][] G = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];
            Route start = null;
            Route end = null;
            int time = 0;

            for (int l = 0; l < L; l++) {
                for (int i = 0; i < R; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < C; j++) {
                        G[l][i][j] = line.charAt(j);
                        if (G[l][i][j] == 'S') {
                            start = new Route(i, j, l, 0);
                        } else if (G[l][i][j] == 'E') {
                            end = new Route(i, j, l, 0);
                        }
                    }
                }
                br.readLine();
            }

            visited[start.z][start.x][start.y] = true;

            Queue<Route> Q = new ArrayDeque<>();

            Q.add(start);
            while (!Q.isEmpty()) {
                Route cur = Q.poll();
                int x = cur.x;
                int y = cur.y;
                int z = cur.z;
                if (z == end.z && x == end.x && y == end.y) {
                    time = cur.t;
                }
                for (int i = 0; i < 6; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];

                    if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L ||
                            visited[nz][nx][ny] || G[nz][nx][ny] == '#') {
                        continue;
                    }
                    visited[nz][nx][ny] = true;
                    Q.add(new Route(nx, ny, nz, cur.t + 1));
                }

            }

            if (time != 0) {
                String ans = String.format("Escaped in %d minute(s).", time);
                sb.append(ans).append("\n");
            } else {
                sb.append("Trapped!").append("\n");
            }
        }
        System.out.println(sb);


    }
}
