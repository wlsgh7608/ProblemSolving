import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Virus implements Comparable<Virus> {
        int x;
        int y;
        int n;
        int t;

        public Virus(int x, int y, int n, int t) {
            this.x = x;
            this.y = y;
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo(Virus o) {
            if (this.t == o.t) {
                return this.n - o.n;
            }
            return this.t - o.t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] G = new int[N][N];

        PriorityQueue<Virus> Q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                if (G[i][j] != 0) {
                    Q.add(new Virus(i, j, G[i][j], 0));

                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!Q.isEmpty()) {
            Virus cur = Q.poll();
            int x = cur.x;
            int y = cur.y;
            int n = cur.n;
            int t = cur.t;
            if(t>=S){
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || G[nx][ny] != 0) {
                    continue;
                }
                G[nx][ny] = n;
                Q.add(new Virus(nx, ny, G[nx][ny], t + 1));
            }
        }
        System.out.println(G[X-1][Y-1]);


    }
}