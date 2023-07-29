class Solution {
    public int integerBreak(int n) {
        
        // 2 : 1 + 1 
        
        // 3 : 1 + 2
        //     2 + 1
        
        // 4 : 1 + 1 + 1 + 1
        //     1 + 1 + 2
        //     1 + 3
        //     2 + 2
        //     3 + 1
        
        int[] dp = new int[58+1];
        dp[1] = 1; // 곱셈 연산
        dp[2] = 1;
        
        
        for(int i = 3 ; i<=58;i++){
            for(int j = 1 ; j< i;j++){
                
                int beforeMax = Math.max(dp[i-j],i-j);
                dp[i] = Math.max(dp[i],beforeMax*j);
            }
        }
        return dp[n];
        
        
    }
}