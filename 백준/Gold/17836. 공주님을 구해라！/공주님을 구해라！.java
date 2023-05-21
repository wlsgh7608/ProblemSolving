import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] G = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int swordX = -1;
        int swordY = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                if (G[i][j] == 2) {
                    swordX = i;
                    swordY = j;
                }
            }
        }
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(new Node(0, 0, 0));
        int maxT = 10_001;
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            int x = cur.x;
            int y = cur.y;
            int t = cur.t;
            if (x == swordX && y == swordY) {
                int time = t + (N - 1 - x) + (M - 1 - y);
                maxT = Math.min(maxT, time);
                continue;
            }

            if (x == N - 1 && y == M - 1) {
                maxT = Math.min(maxT, t);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || G[nx][ny] == 1) {
                    continue;
                }
                visited[nx][ny] = true;
                Q.add(new Node(nx, ny, t + 1));

            }
        }
        if(maxT<=T){
            System.out.println(maxT);
        }else{
            System.out.println("Fail");
        }
    }
}
