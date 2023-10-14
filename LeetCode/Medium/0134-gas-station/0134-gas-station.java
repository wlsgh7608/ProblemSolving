class Solution {
    static boolean isImPossible(int[] gas, int[] cost){
        int gasSum = 0;
        int costSum = 0;
        
        for(int n : gas){
            gasSum+=n;
        }
        for(int n : cost){
            costSum+=n;
        }
        
        return costSum>gasSum;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tot = 0;
        int idx = 0;
        
        int N = gas.length;
        if(isImPossible(gas,cost)){
           return -1; 
        }
        
        for(int i = 0 ; i<N;i++){
            int diff = gas[i] - cost[i];
            tot+=diff;
            if(tot<0){
                tot = 0;
                idx = i+1;
            }
        }
        if(idx==N){
            return -1;
        }else{
            return idx;
        }
    }
}