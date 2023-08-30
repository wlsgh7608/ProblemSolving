import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int DEFAULT = 50;

    static long getCount(int a, int idx, int openCnt) {

        if (idx == N) {
            if(a==1 && openCnt==DEFAULT){
                return 0;
            }
            return 1;
        }
        // 이미 값을 구했다면
        if (dp[a][idx][openCnt] != -1) {
            return dp[a][idx][openCnt];
        }
        // 이미 ㄴㄴ 문자열이라면
        if (openCnt < DEFAULT) {
            a = 0;
        }
        dp[a][idx][openCnt] = 0;

        dp[a][idx][openCnt] += getCount(a, idx + 1, openCnt + 1);
        dp[a][idx][openCnt] += getCount(a, idx + 1, openCnt - 1);
        return dp[a][idx][openCnt];
    }

    static void solve(int a, int idx, int openCnt, long cnt) {
        if(idx==N){
            return;
        }

        if(openCnt<DEFAULT){
            a = 0;
        }
        long pivot = getCount(a, idx + 1, openCnt + 1);
        if (pivot <= cnt) {
            answer[idx] = ')';
            solve(a, idx + 1, openCnt - 1, cnt - pivot);
        } else {
            answer[idx] = '(';
            solve(a, idx + 1, openCnt + 1, cnt);
        }
    }

    static long[][][] dp = new long[2][DEFAULT + 1][2 * DEFAULT + 1]; // ㄴㄴ여부, 길이, 닫히지 않은 ( 개수 (default : 50)
    static int N;
    static char[] answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        answer = new char[N];
        long K = Long.parseLong(st.nextToken());
        for (long[][] G : dp) {
            for (long[] row : G) {
                Arrays.fill(row, -1);
            }
        }

        getCount(1, 0, DEFAULT);

        if (dp[1][0][DEFAULT] <= K) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            solve(1, 0, DEFAULT, K);
            for (char c : answer) {
                sb.append(c);
            }
            System.out.println(sb);

        }

    }

}
