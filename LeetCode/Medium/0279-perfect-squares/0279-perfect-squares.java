class Solution {
    public int numSquares(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,10_001);
        for(int i = 1 ; i*i <= n;i++){
            dp[i*i] = 1;
        }
        
        for(int i = 2;i<=n;i++){
            for(int j = 1; j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
        
        
    }
}