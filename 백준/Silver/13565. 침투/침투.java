import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] G;
    static boolean[][] visited;
    static int N, M;

    static boolean isPossible = false;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                G[i][j] = row.charAt(j) - '0';
            }
        }
        visited = new boolean[N][M];

        for (int j = 0; j < M; j++) {
            if (G[0][j] == 0 && !visited[0][j]) {
                dfs(0, j);
            }
        }
        if(isPossible){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    private static void dfs(int x,int y) {
        visited[x][y] = true;
        if(x==N-1){
            isPossible = true;
        }
        for(int i =0 ;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||ny<0||nx>=N||ny>=M) continue;
            if(G[nx][ny]==0 && !visited[nx][ny]){
                dfs(nx,ny);
            }
        }
    }
}
