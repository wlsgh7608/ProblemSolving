import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_STR = 5;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
    static HashMap<String,Integer> hm = new HashMap<>();
    static int N,M,K;
    static char[][] G;


    static void dfs(int x, int y,String route){
        hm.put(route, hm.getOrDefault(route, 0) + 1);
        if(route.length()==MAX_STR){
            return;
        }
        for(int i = 0; i<8;i++){
            int nx = (x + N + dx[i]) % N;
            int ny = (y + M + dy[i]) % M;

            dfs(nx, ny, route + G[nx][ny]);
        }
    }


    public static void main(String[] args) throws Exception{
        // 10*10*8^5 = 640만
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        G = new char[N][M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                G[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dfs(i,j, G[i][j]+"");
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            String query = br.readLine();
            int result = hm.getOrDefault(query, 0);
            sb.append(result).append("\n");
        }
        System.out.println(sb);


    }
}
