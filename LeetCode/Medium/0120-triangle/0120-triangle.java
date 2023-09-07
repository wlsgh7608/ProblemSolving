class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        
        for(int i = 0 ; i<N;i++){
            List list = triangle.get(i);
            for(int j = list.size()-1 ; j>=0;j--){
                dp[j+1] = Math.min(dp[j+1],dp[j]) + (int)list.get(j);
            }
        }
        
        int minValue = Integer.MAX_VALUE;
        for(int i = 1; i<=N;i++){
            minValue = Math.min(minValue,dp[i]);
        }
        return minValue;
        
        
        
        
    }
}