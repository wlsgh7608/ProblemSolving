import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long dfs(int n, int m) {
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if(n==0||m==0){
            return dp[n][m] = 1;
        }
        long result = dfs(n - 1, m);
        if (m > 0) {
            result += dfs(n - 1, m - 1);
        }
        return dp[n][m] = result;
    }

    static void find(int n, int m, long k, int depth) {
        if (n == 0 || m == 0) {
            return;
        }
        long cnt = dfs(n - 1, m);
        if (cnt <= k) {
            answer[depth] = '1';
            find(n - 1, m - 1, k - cnt, depth + 1);
        } else {
            answer[depth] = '0';
            find(n - 1, m, k, depth + 1);
        }

    }


    static long[][] dp; // n자리 1의 개수 자리
    static char[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 길이
        int L = Integer.parseInt(st.nextToken()); // 1 개수
        long I = Long.parseLong(st.nextToken()); // i 번째
        dp = new long[N + 1][N + 1];
        answer = new char[N];
        Arrays.fill(answer, '0');
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[0][0] = 1;
        find(N, L, I-1, 0);

        StringBuilder sb = new StringBuilder();
        for(char c : answer){
            sb.append(c);
        }
        System.out.println(sb);

    }
}
