import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dfs(int depth, int a, int b, int[] arr){
        if(depth==arr.length){
            return 0;
        }
        if(dp[depth][a][b]!=-1){
            return dp[depth][a][b];
        }
        int leftMove = dfs(depth+1,arr[depth], b, arr)+Math.abs(a-arr[depth]);
        int rightMove = dfs(depth+1,a, arr[depth], arr)+Math.abs(b-arr[depth]);
        dp[depth][a][b] = Math.min(leftMove,rightMove);
        return dp[depth][a][b];
    }
    static int[][][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[21][N+1][N+1];
        for(int i=0;i<=20;i++){
            for(int j=0;j<=N;j++){
                for(int k=0;k<=N;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        for(int i=0;i<M;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(dfs(0,a,b,arr));



    }
}
