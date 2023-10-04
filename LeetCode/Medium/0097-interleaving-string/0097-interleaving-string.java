class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int N = s1.length();
        int M = s2.length();
        
        if(N+M != s3.length()){
            return false;
        }
        
        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][0] = true;
        
        
        int[] dx = {0,1};        
        int[] dy= {1,0};
        
        Queue<int[]> Q  = new ArrayDeque<>();
        Q.add(new int[]{0,0});
        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i = 0; i<2;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<=N && ny<=M){
                    if(dp[nx][ny]){
                        continue;
                    }

                    if(i ==1){
                        if(s3.charAt(nx+ny-1)==s1.charAt(nx-1)){
                            dp[nx][ny] = true;
                            Q.add(new int[]{nx,ny});
                        }
                    }else{
                        if(s3.charAt(nx+ny-1)==s2.charAt(ny-1)){
                            dp[nx][ny] = true;
                            Q.add(new int[]{nx,ny});
                        }
                    }
                }
                
            }
            
        }
  
        return dp[N][M];
        
        
    }
}