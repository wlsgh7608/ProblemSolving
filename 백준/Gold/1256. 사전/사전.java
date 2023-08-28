import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long getCount(int a, int z) {
        // 끝에 도달
        if (a == N && z == M) {
            return 1;
        }
        // 범위를 넘어버리는 경우
        if (a > N || z > M) {
            return 0;
        }

        // 이미 존재
        if (dp[a][z] != -1) {
            return dp[a][z];
        }
        dp[a][z] = 0;
        dp[a][z] += getCount(a + 1, z);
        dp[a][z] += getCount(a, z + 1);
        if(dp[a][z]>1_000_000_001){
            return dp[a][z] = 1_000_000_001;
        }
        return dp[a][z];
    }


    static void solve(int idx, int a, int z, long n) {
        long pivot = getCount(a + 1, z);
        if (idx == N + M) {
            return;
        }

        if (pivot >= n) {
            answer[idx] = 'a';
            solve(idx + 1, a + 1, z, n);

        } else {
            answer[idx] = 'z';
            solve(idx + 1, a, z + 1, n - pivot);
        }
    }

    static long[][] dp;
    static int N, M;
    static char[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new char[N + M];
        int K = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][M + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        getCount(0, 0);

        if (dp[0][0] < K) {
            System.out.println(-1);
        } else {
            solve(0, 0, 0, K);
            StringBuilder sb = new StringBuilder();
            for (char c : answer) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
