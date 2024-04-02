import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        int N = enroll.length;
        int[] referralArr = new int[N];
        int[] result = new int[N];
        
        // name -> idx 저장
        for(int i = 0 ; i < N; i++){
            hm.put(enroll[i],i);        
        }
        
        // 추천인 인덱스 저장
        for(int i = 0 ; i < N; i++){
            int referralIdx = hm.getOrDefault(referral[i],-1);
            referralArr[i] = referralIdx;
        }
        
        int sellSize = seller.length;
        
        for(int i =0 ; i<sellSize; i++){
            // 현재 남은 금액
            int remain = amount[i]*100;
            // 현재 인덱스
            int curIdx = hm.get(seller[i]);
            
            // 현재 인덱스가 center가 될 때까지 올라감. 나머지 금액이 0이면 종료
            while(curIdx != -1 && remain>0){
                int referralIdx = referralArr[curIdx];
                // 나는 90%
                result[curIdx] += (int)Math.ceil(1.0*remain*9/10);
                // 나머지는 10%
                remain = remain/10;
                curIdx = referralIdx;        
            }            
        }                
        return result;
    }
}