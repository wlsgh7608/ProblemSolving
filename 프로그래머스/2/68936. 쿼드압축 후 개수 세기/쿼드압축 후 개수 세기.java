class Solution {
    int[] result;
    
    private void dfs(int startX,int startY,int size,int[][] arr){

        int value = arr[startX][startY];
        if(size==1){
            result[value]++;
            return;
        }
        boolean isCompressPossible = true;
        
        endLoop:
        for(int i = startX;i<startX+size;i++){
            for(int j = startY;j<startY+size;j++){
                if(arr[i][j]!=value){
                    isCompressPossible = false;
                    break endLoop;
                }
            }
        }
        
        if(isCompressPossible){
            result[value]++;
        }else{
            int halfSize = size/2;
            dfs(startX,startY,halfSize,arr);
            dfs(startX+halfSize,startY,halfSize,arr);
            dfs(startX,startY+halfSize,halfSize,arr);
            dfs(startX+halfSize,startY+halfSize,halfSize,arr);
        }
    }
    
    public int[] solution(int[][] arr) {
        
        int n = arr.length;
        result = new int[2];
        dfs(0,0,n,arr);
        return result;
    }
}