class Solution {
    public int numberOfBeams(String[] bank) {
        int result  = 0;
        int N = bank.length;
        int M = bank[0].length();
        
        
        int prevRowCnt = 0;
        
        
    
        for(String row : bank){
            int rowCnt = 0;
            for(int i = 0 ;i <M;i++){
                if(row.charAt(i)=='1'){
                    rowCnt++;
                }
            }
            
            if(rowCnt>0){
                result+= prevRowCnt*rowCnt;
                prevRowCnt = rowCnt;
            }
        }
        return result;
        
    }
}