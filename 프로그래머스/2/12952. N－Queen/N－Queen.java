class Solution {
    
    
    boolean isLocate(int depth,int idx,int[] queenArr){
        // 상하 확인
        for(int i = 0; i< depth;i++){
            if(queenArr[i] == idx){
                return false;
            }
        }
        
        //대각선 확인
        for(int i = 0; i<depth;i++){
            int upDownDiff = Math.abs(i-depth);
            int leftRightDiff = Math.abs(queenArr[i]-idx);
            if(upDownDiff==leftRightDiff){
                return false;
            }
        }
        
        return true;
        
    
    }
    
    int dfs(int depth,int[] queenArr){
        if(depth== N){
            return 1;
        }
        int result = 0;
        
        for(int i = 0 ; i< N;i++){
            if(isLocate(depth,i,queenArr)){
                
                queenArr[depth] = i;
                result += dfs(depth+1,queenArr);
            }
        }
        return result;
        
    }
    static int N;
    
    
    
    public int solution(int n) {
        N = n;
        int[] queenArr = new int[n];
        int result = dfs(0,queenArr);
        
        return result;
    }
}