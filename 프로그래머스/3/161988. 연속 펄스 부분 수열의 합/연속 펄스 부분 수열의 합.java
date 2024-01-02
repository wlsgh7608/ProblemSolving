class Solution {
    public long solution(int[] sequence) {
        //연속 펄스 부분 수열의 합 가장 큰 것 리턴하기
        
        int N = sequence.length;
        // MAX = 500_000 * 100_000 => 500억?


        long answer = 0;
        
        
        // 1 -1  1 -1  1 -1  1 -1 
        // 2  3 -6  1  3 -1  2  4
        // 2 -3 -6 -1  3  1  2 -4
        // 
        int[] calc = new int[N];
        
        int p = 1; 
        for(int i = 0 ;i <N;i++){
            calc[i] = sequence[i]*p;
            p*=-1;
        }
        
        long plus = 0;
        long minus = 0;
        long result = 0;
        
        for(int  i = 0 ; i<N;i++){
            int cur = calc[i];
            
            plus +=cur;
            minus +=cur;
            
            if(isPlus(calc[i])){
                plus = Math.max(plus,cur);
            }else{
                minus = Math.min(minus,cur);
            }
            
            long maxSum = Math.max(Math.abs(plus),Math.abs(minus));
            result = Math.max(result,maxSum); 
        }
        
        
        return result;
    }
    
    private boolean isPlus(int n){
        return n>0;
    }
}