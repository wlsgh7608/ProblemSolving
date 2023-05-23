import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C + 1+100];
        Arrays.fill(dp,1_000_000_000);
        dp[0] = 0;

        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            for(int j = p;j<=C+100;j++){
                dp[j] = Math.min(dp[j], dp[j - p] + c);
            }
        }

        int result = 1_000_000_000;
        for(int i = C; i <=C+100;i++){
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
