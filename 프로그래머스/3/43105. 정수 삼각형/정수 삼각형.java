import java.util.*;
class Solution {
  public int solution(int[][] triangle) {
        int N = triangle.length;

        // maxValue = 500 * 10000 = 5_000_000
        int[] dp = new int[N+1];


        int maxLen = 0;
        for (int[] row : triangle) {
            for (int j = maxLen; j >= 0; j--) {
                dp[j + 1] = Math.max(dp[j + 1], dp[j]) + row[j];
            }
            maxLen++;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}