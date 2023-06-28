import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            int[] dp = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                dp[i] = dp[i-1]+arr[i];
            }
            int maxResult = Integer.MIN_VALUE;
            for(int i =1;i<=N;i++){
                for(int j=i;j<=N;j++){
                    int result = dp[j]-dp[i-1];
                    maxResult = Math.max(maxResult, result);
                }
            }
            sb.append(maxResult).append("\n");
        }// end for
        System.out.println(sb);
    }
}
