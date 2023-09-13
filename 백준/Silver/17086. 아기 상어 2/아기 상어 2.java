import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish {
        int x;
        int y;
        int cnt;

        public Fish(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] G = new int[N][M];
        boolean[][] visited = new boolean[N][M];



        List<Fish> fishes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
                if (G[i][j] == 0) {
                    fishes.add(new Fish(i, j, 0));
                }
            }
        }
        int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
        int[] dy = {-1, 0, 1, -1, 0, 1, 1, -1};

        int result = 0;
        for(Fish fish : fishes){
            visited = new boolean[N][M];
            Queue<Fish> Q = new ArrayDeque<>();
            Q.add(new Fish(fish.x, fish.y, fish.cnt));
            visited[fish.x][fish.y]=true;
            while (!Q.isEmpty()) {
                Fish cur = Q.poll();
                int x = cur.x;
                int y = cur.y;
                int cnt = cur.cnt;

                if (visited[x][y] && G[x][y] == 1) {
                    result = Math.max(result, cnt);
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    Q.add(new Fish(nx, ny, cnt + 1));
                }
            }
        }
        System.out.println(result);




    }
}
