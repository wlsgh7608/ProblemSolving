import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int[] balls;

    static int recur(int k1, int k2, int turn) {
        if (dp[k1][k2] != -1) {
            return dp[k1][k2];
        }


        for (int ball : balls) {
            if (k1 - ball >= 0 && recur(k1 - ball, k2, turn ^ 1) == 0) {
                return dp[k1][k2] = 1;
            }
            if (k2 - ball >= 0 && recur(k1, k2 - ball, turn ^ 1) == 0){
                return dp[k1][k2] = 1;
            }
        }
        return dp[k1][k2] = 0;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        balls = new int[3];
        for (int i = 0; i < 3; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[501][501];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());
            int result = recur(k1, k2, 0);
            if(result==1){
                sb.append("A").append("\n");
            }else{
                sb.append("B").append("\n");
            }
        }
        System.out.println(sb);


    }
}
