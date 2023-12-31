import java.util.*;

class Solution {

    private static final int INF = 100_000;
    public int solution(int n, int[][] results) {
        
        
        // 1-based (1~n)
        int[][] G = new int[n+1][n+1];
        
        for(int[] row: G){
            Arrays.fill(row,INF);
        }
        for(int i = 1 ;i<=n;i++){
            G[i][i] = 1;
        }
        
        
        for(int[] result : results){
            int winIdx = result[0];
            int loseIdx = result[1];
            
            // 결과값 업데이트
            G[winIdx][loseIdx] = 1;
        }
        
        for(int k = 1; k<=n;k++){
            for(int i= 1;i<=n;i++){
                for(int j = 1; j <=n;j++){
                    G[i][j] = Math.min(G[i][j],G[i][k]+G[k][j]);
                }
            }
        }
        
        
        int canCnt = 0;
        
        loop:
        for(int i = 1; i<=n;i++){
            for(int j =1 ; j<=n;j++){
                if(G[i][j]==INF && G[j][i] == INF){
                    continue loop;
                }
            }
            canCnt++;
        }
        
        for(int[] row: G){
            System.out.println(Arrays.toString(row));
        }
        
        return canCnt;
    }
}