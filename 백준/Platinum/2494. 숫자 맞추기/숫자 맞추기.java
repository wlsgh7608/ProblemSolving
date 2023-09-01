import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long getCount(int idx, int loc) {
        if (idx == N) {
            return 0;
        }

        if (dp[idx][loc] != -1) {
            return dp[idx][loc];
        }

        dp[idx][loc] = 0;

        // 왼쪽 오른쪽 개수 정하기
        int num = (start[idx] + loc) % 10;
        int target = end[idx];
        int leftCnt = (10 + num - target) % 10;
        int rightCnt = (10 + target - num) % 10;

        long left = getCount(idx + 1, loc) + leftCnt;
        long right = getCount(idx + 1, (loc + rightCnt) % 10) + rightCnt;
        return dp[idx][loc] = Math.min(left, right);
    }

    static void trace(int idx, int loc) {
        if (idx == N) {
            return;
        }
        int num = (start[idx] + loc) % 10;
        int target = end[idx];

        int leftCnt = (10 + num - target) % 10;
        int rightCnt = (10 + target - num) % 10;

        long left = getCount(idx + 1, loc) + leftCnt;
        long right = getCount(idx + 1, (loc + rightCnt) % 10) + rightCnt;
        if (left < right) {
            if (leftCnt > 0) {
                sb.append(idx + 1).append(" ");
                sb.append(-1 * leftCnt).append("\n");
            }
            trace(idx + 1, loc);
        } else {
            if (rightCnt > 0) {
                sb.append(idx + 1).append(" ");
                sb.append((rightCnt)).append("\n");
            }
            trace(idx + 1, (loc + rightCnt) % 10);
        }

    }

    static StringBuilder sb = new StringBuilder();

    static int[] start;
    static int[] end;
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        start = new int[N];
        end = new int[N];
        for (int i = 0; i < N; i++) {
            start[i] = line.charAt(i) - '0';
        }
        line = br.readLine();
        for (int i = 0; i < N; i++) {
            end[i] = line.charAt(i) - '0';
        }
        dp = new long[N][10];// idx,num,(왼 or 오)
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        getCount(0, 0);
        sb.append(dp[0][0]).append("\n");
        trace(0, 0);
        System.out.println(sb);


    }
}
