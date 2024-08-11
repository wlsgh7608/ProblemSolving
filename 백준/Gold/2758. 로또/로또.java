import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static long[][] dp;

    static long dfs(int depth, int cur) {
        if (depth == 1) {
            return 1;
        }
        if (dp[depth][cur] != -1) {
            return dp[depth][cur];
        }

        dp[depth][cur] = 0;
        for (int i = cur / 2; i >= 1; i--) {
            dp[depth][cur] += dfs(depth - 1, i);
        }
        return dp[depth][cur];
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new long[N + 1][M + 1];
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    dp[i][j] = -1;
                }
            }

            long result = 0;
            for (int i = M; i >= 1; i--) {
                result += dfs(N, i);
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }
}
