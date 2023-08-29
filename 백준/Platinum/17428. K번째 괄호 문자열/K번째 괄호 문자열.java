import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long getCount(int idx, int openCnt) {
        if (openCnt < 0) {
            return 0;
        }
        if (idx == N) {
            if (openCnt == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[idx][openCnt] != -1) {
            return dp[idx][openCnt];
        }
        dp[idx][openCnt] = 0;
        dp[idx][openCnt] += getCount(idx + 1, openCnt + 1); // ( (
        dp[idx][openCnt] += getCount(idx + 1, openCnt - 1); // ( )
        return dp[idx][openCnt];
    }

    static void solve(int idx, int openCnt, long cnt) {
        if (idx == N) {
            return;
        }

        long pivot = getCount(idx + 1, openCnt + 1);
        if (pivot <= cnt) {
            answer[idx] = ')';
            solve(idx + 1, openCnt - 1, cnt - pivot);

        } else {
            answer[idx] = '(';
            solve(idx + 1, openCnt + 1, cnt);

        }
    }

    static long[][] dp = new long[51][51];
    static int N;
    static char[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        getCount(0, 0);
        long K = Long.parseLong(st.nextToken());
        answer = new char[N];
        if (dp[0][0] <= K) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            solve(0, 0, K);
            for (char c : answer) {
                sb.append(c);
            }
            System.out.println(sb);

        }


    }
}
