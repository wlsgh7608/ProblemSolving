import java.util.*;
class Solution {
    public long solution(int[] weights) {
        
        long[] cnt = new long [1001];
        long answer = 0;
        for(int w : weights){
            cnt[w]++;
        }
        
        for(int i = 100; i<=1000;i++){
            if(cnt[i]==0){
                continue;
            }
            if(cnt[i]>1){
                answer+= cnt[i]*(cnt[i]-1)/2;
            }
            
            if((i%2==0) && (i+i/2<=1000)&&(cnt[i+i/2]>0)){
                answer+=cnt[i]*cnt[i+i/2];
            }
            
                        
            if((i%3==0) && (i+ i/3<=1000)&&(cnt[(i+ i/3)]>0)){
                answer+=cnt[i]*cnt[i+i/3];
            }
            
            
            if(i*2 <=1000 && cnt[i*2]>0){
                answer+=cnt[i]*cnt[i*2];
            }
            
        }
        
        
        

        return answer;
    }
}