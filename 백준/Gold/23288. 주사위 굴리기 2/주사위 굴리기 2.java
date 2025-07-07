import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M, d;
    static int[][] depth;
    static int[][] G;
    static int[] dice = {1, 2, 3, 4, 5, 6};
    public static void moveDice() {
        // 동쪽
        if (d == 0) {
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;

        } else if (d == 1) {  // 남쪽
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[4];
            dice[4] = temp;
        } else if (d == 2) { // 서쪽
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
        } else if (d == 3) { // 북쪽
            int temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
        }
    }


    static void traverse(int x, int y, int v) {
        int cnt = 1;
        depth[x][y] = 0;
        List<Point> list = new ArrayList<>();
        Queue<Point> Q = new ArrayDeque<>();

        Q.add(new Point(x, y));
        list.add(new Point(x, y)); // 칸 개수를 대입하기 위함
        while (!Q.isEmpty()) {
            Point cur = Q.poll();

            int cx = cur.x;
            int cy = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (depth[nx][ny] == -1 && G[nx][ny] == v) {
                    depth[nx][ny] = 0;
                    Q.add(new Point(nx, ny));
                    list.add(new Point(nx, ny));
                    cnt++;
                }
            }
        }

        for (Point cur : list) {
            depth[cur.x][cur.y] = cnt;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        depth = new int[N][M];
        G = new int[N][M];


        for (int[] row : depth) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (depth[i][j] == -1) {
                    traverse(i, j, G[i][j]);
                }
            }
        }

        int score = 0;
        int cx = 0;
        int cy = 0;

        while (T-- > 0) {
            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                d = (d + 2) % 4;
                nx = cx + dx[d];
                ny = cy + dy[d];
            }

            moveDice();
            score += depth[nx][ny] * G[nx][ny];

            // 아래에 있는 주사위 idx : 5
            int curDice = dice[5];
            if (curDice > G[nx][ny]) {
                d = (d + 1) % 4;
            } else if (curDice < G[nx][ny]) {
                d = (d - 1 + 4) % 4;
            }
            cx = nx;
            cy = ny;
        }


        System.out.println(score);

    }
}
