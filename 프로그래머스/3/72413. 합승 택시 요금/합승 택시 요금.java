import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // s -> m
        // m -> a
        // m -> b 경로 계산
        int[][]dp = new int[n+1][n+1];
        int MAX_COST = 100_000*200;
        for(int[] row : dp){
            Arrays.fill(row,MAX_COST);
        }
        for(int i = 1; i<=n;i++){
            dp[i][i] = 0;
        }
        
        for(int[] fare : fares){
            int v1 = fare[0];
            int v2 = fare[1];
            int cost = fare[2];
            
            dp[v1][v2] = cost;
            dp[v2][v1] = cost;
        }
        
        
        for(int k = 1; k<=n ; k++){
            for(int i = 1; i<=n ; i++){
                for(int j = 1 ; j<=n ; j++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        // for(int[] row : dp){
        //     System.out.println(Arrays.toString(row));
        // }
        int minCost = MAX_COST*2;
        
        for(int i = 1;i<=n;i++){
            int cost = dp[s][i] + dp[i][a] + dp[i][b];
            minCost = Math.min(minCost,cost);
        }
        
        return minCost;
    }
}