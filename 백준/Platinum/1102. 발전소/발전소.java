import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int P;
    static int[][] G;
    static int[] dp;

    static int dfs(int flag) {
        if (Integer.bitCount(flag) >= P) {
            return dp[flag] = 0;
        }
        if (dp[flag] != 100_000_000) {
            return dp[flag];
        }

        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) {
                for (int j = 0; j < N; j++) {
                    if ((flag & 1 << j) == 0) {
                        dp[flag] = Math.min(dp[flag], dfs(flag | 1 << j) + G[i][j]);
                    }
                }
            }
        }
        return dp[flag];

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        G = new int[N][N];
        dp = new int[1 << N];
        int flag = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(dp, 100_000_000);

        String init = br.readLine();
        for (int i = 0; i < init.length(); i++) {
            if (init.charAt(i) == 'Y') {
                flag |= (1 << i);
            }
        }

        P = Integer.parseInt(br.readLine());

        int ans = dfs(flag);
        if (ans == 100_000_000) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }


    }
}
