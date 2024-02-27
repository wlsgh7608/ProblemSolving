import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] G;
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static void dfs(int x, int y, int depth, int cnt) {
        if (cnt == 3) {
            answer = Math.min(answer, depth);
            return;
        }
        if(depth>=answer){
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || G[nx][ny] == -1) {
                continue;
            }

            if (G[nx][ny] == 1) {
                G[nx][ny] = -1;
                dfs(nx, ny, depth + 1, cnt + 1);
                G[nx][ny] = 1;
            } else {
                G[nx][ny] = -1;
                dfs(nx, ny, depth + 1, cnt);
                G[nx][ny] = 0;
            }
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        G = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        G[x][y] = -1;
        dfs(x, y, 0, 0);
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);

    }
}
