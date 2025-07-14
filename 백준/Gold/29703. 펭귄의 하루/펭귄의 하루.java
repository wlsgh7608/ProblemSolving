import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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

    static int[][] getDist(Point start) {

        int dist = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[N][M];
        int[][] distArr = new int[N][M];

        for (int[] arr : distArr) {
            Arrays.fill(arr, -1);
        }

        Queue<Point> Q = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        Q.add(start);
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int s = 0; s < size; s++) {
                Point cur = Q.poll();
                int x = cur.x;
                int y = cur.y;
                distArr[x][y] = dist;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || G[nx][ny] == 'D' || visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    Q.add(new Point(nx, ny));

                }
            }
            dist++;

        }
        return distArr;

    }

    static int N, M;
    static char[][] G;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        Point start = null;
        Point end = null;

        G = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                G[i][j] = str.charAt(j);
                if (G[i][j] == 'S') {
                    start = new Point(i, j);
                } else if (G[i][j] == 'H') {
                    end = new Point(i, j);
                }
            }
        }

        int[][] startToFishDist = getDist(start);
        int[][] endToFishDist = getDist(end);


        int answer = Integer.MAX_VALUE;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (G[i][j] == 'F') {
                    if (startToFishDist[i][j] != -1 && endToFishDist[i][j] != -1) {
                        answer = Math.min(answer, startToFishDist[i][j] + endToFishDist[i][j]);
                    }
                }
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }


    }

}
