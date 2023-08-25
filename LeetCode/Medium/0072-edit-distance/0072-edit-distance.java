class Solution {
    public int minDistance(String word1, String word2) {
        
        int N = word1.length();
        int M = word2.length();
        int[][] dp = new int [N+1][M+1];
        
        char[] start = new char[N+1];
        char[] end = new char[M+1];
        
        for(int i = 0; i <N;i++){
            start[i+1] = word1.charAt(i);
        }
        for(int i = 0 ; i<M;i++){
            end[i+1] = word2.charAt(i);
        }

        final int MAX_VALUE = 501;
        for(int i = 0; i<=N;i++){
            for(int j = 0; j<=M;j++){
                dp[i][j] = MAX_VALUE;
            }
        }
        for(int i = 0; i<=N;i++){
            dp[i][0] = i;
        }
        for(int j = 0; j<=M;j++){
            dp[0][j] = j;
        }
        for(int i = 1; i<=N;i++){
            for(int j = 1; j<=M;j++){
                char c1 = start[i];
                char c2 = end[j];
                
                
                if(c1==c2){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                    
                }
               
            }
        }
        
        return dp[N][M];
        
        
    }
}