import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            max = Math.max(dp[i], max);
            dp[i] = max;

            if (i + day <= N) {
                dp[i + day] = Math.max(dp[i + day], dp[i] + cost);
            }
        }
        max = Math.max(max, dp[N]);
        System.out.println(max);


    }
}
