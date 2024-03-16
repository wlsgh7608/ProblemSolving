import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // i까지 왔는 데 현재 depth
    static int dfs(int depth, int turn, int cnt) {
        if (cnt == ringLen) {
            return 1;
        }


        if (dp[depth][turn][cnt] != -1) {
            return dp[depth][turn][cnt];
        }

        dp[depth][turn][cnt] = 0;

        int charIdx = rings.charAt(cnt) - 'A';
        if (turn == 0) {
            for (int next : angelList[charIdx]) {
                if (depth < next) {
                    dp[depth][turn][cnt] += dfs(next, turn ^ 1, cnt + 1);
                }
            }
        } else {
            for (int next : devilList[charIdx]) {
                if (depth < next) {
                    dp[depth][turn][cnt] += dfs(next, turn ^ 1, cnt + 1);
                }
            }
        }
        return dp[depth][turn][cnt];
    }

    static int[][][] dp;
    static int N;
    static int ringLen;
    static String rings;

    static List<Integer>[] devilList;
    static List<Integer>[] angelList;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        rings = br.readLine();
        ringLen = rings.length();

        char[] devil = br.readLine().toCharArray();
        char[] angel = br.readLine().toCharArray();
        int N = devil.length;

        dp = new int[N + 1][2][ringLen];
        devilList = new ArrayList[26];
        angelList = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            devilList[i] = new ArrayList<>();
            angelList[i] = new ArrayList<>();
        }


        for (int i = 1; i <= N; i++) {
            char c = devil[i - 1];
            devilList[c - 'A'].add(i);
        }
        for (int i = 1; i <= N; i++) {
            char c = angel[i - 1];
            angelList[c - 'A'].add(i);
        }
        for (int[][] G : dp) {
            for (int[] row : G) {
                Arrays.fill(row, -1);
            }
        }
        dfs(0, 0, 0);
        dfs(0, 1, 0);

        int ans = dp[0][0][0] + dp[0][1][0];
        System.out.println(ans);


    }
}
