import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    static void check(int n, int cnt) {
        if (1 <= n && n <= 32_000) {
            dp[n] = Math.min(dp[n], cnt);
        }
        hs[cnt].add(n);
    }

    static int K;
    static int[] dp;
    static HashSet<Integer>[] hs;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        dp = new int[32_001];
        Arrays.fill(dp, 10);

        StringBuilder sb = new StringBuilder();
        hs = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            hs[i] = new HashSet<>();
        }


        int tmp = 0;
        for (int i = 1; i <= 8; i++) {
            tmp = 10 * tmp + K;
            hs[i].add(tmp);
            if (1 <= tmp && tmp <= 32_000) {
                dp[tmp] = i;

            }
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; i + j <= 8; j++) {
                int sum = i + j;

                for (int x : hs[i]) {
                    for (int y : hs[j]) {
                        check(x + y, sum);
                        check(x - y, sum);
                        check(y - x, sum);
                        check(x * y, sum);
                        if (y != 0) {
                            check(x / y, sum);
                        }
                        if (x != 0) {
                            check(y / x, sum);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int q = Integer.parseInt(br.readLine());
            if (dp[q] == 10) {
                sb.append("NO").append("\n");
            } else {
                sb.append(dp[q]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
