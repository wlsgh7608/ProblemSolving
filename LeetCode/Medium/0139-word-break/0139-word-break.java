class Solution {
    
    
    static boolean dfs( String str ,int idx, List<String> wordDict){
        if(idx==N){
            return true;
        }
        
        if(dp[idx]){
            return true;
        }
        
        for(String word : wordDict){
            String newStr = str+word;

            if(answer.startsWith(newStr)){
                

                int newIdx = idx+word.length();
                if(newIdx<=N){
                    dfs(newStr,newIdx,wordDict);
                    
                    dp[newIdx] = true;
                }
            }
            
        }
        return false;
        
    }
    
    static boolean[] dp ;
    static String answer;
    static int N ;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        N = s.length();
        dp = new boolean[N+1];
        answer = s;
        dfs("",0,wordDict);
        System.out.println(Arrays.toString(dp));
        if(dp[N]){
            return true;
        }else{
            return false;
        }
    }
}