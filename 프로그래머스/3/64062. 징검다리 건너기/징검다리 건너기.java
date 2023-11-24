class Solution {
    static boolean isPossible(int[] stones,int m,int k){
        int cnt = 0;
        for(int i = 0; i< stones.length;i++){
            if(stones[i]-m<=0){
                cnt++;
                if(cnt>=k){
                    return true;
                }
            }else{
                cnt = 0;
            }
        }
        return false;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        // 0칸이 연속으로 k번 이상될 때 구하기
        
        int lo = 0;
        int hi = 200_000_000;
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(isPossible(stones,m,k)){
                hi = m-1;
            }else{
                lo = m+1;
            }
            
            
        }
        
        return lo;
    }
}