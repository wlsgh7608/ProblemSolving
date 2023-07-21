import java.util.*;

class Solution {
    
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        //col 기준 오름차순, 같으면 pk기준 내림차순
        // row 1
        
        Arrays.sort(data,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[col-1]==b[col-1]){
                    return b[0]-a[0];
                }
                return a[col-1]-b[col-1];
            }
        });
        
        
        int result = 0;
        for(int i = row_begin-1;i<row_end;i++){
            int tupleRemains = 0;
            for(int j = 0 ; j<data[0].length;j++){
                tupleRemains+= data[i][j]%(i+1);
                
            }
            result ^=tupleRemains;
        }
        return result;
        
        
        
    }
}