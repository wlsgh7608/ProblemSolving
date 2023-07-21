class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int N = matrix.length;
        int M = matrix[0].length;
        
        

        int x = 0;
        int y = 0;
        while(x<N && y<M){
            // 1. 맨끝([x][M-1]) 체크
            if(target>matrix[x][M-1]){
                x++;
                continue;
                
            }
            
            // 2. 행 체크
            for(y= 0; y<M;y++){
                if(matrix[x][y]==target){
                    return true;
                }
            }
            
        }
        return false;
        
        
    }
}