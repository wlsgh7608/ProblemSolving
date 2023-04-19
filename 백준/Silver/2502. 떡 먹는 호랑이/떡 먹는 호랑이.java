import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[D];
        int a = 0;
        int b = 0;
        point:
        for (int i = 1; i <= 100_000; i++) {
            for (int j = 1; j < i; j++) {
                dp[0] = j;
                dp[1] = i;
                for (int k = 2; k < D; k++) {
                    dp[k] = dp[k - 2] + dp[k - 1];
                }
                if (dp[D - 1] == K) {
                    a = j;
                    b = i;
                    break point;
                } else if (dp[D - 1] > K) {
                    break;
                }
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
}
