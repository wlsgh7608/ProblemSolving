import java.util.*;
class Solution {
    
    static int solve(int[] queue1,int[] queue2){
        Queue<Integer> Q1 = new ArrayDeque<>();
        Queue<Integer> Q2 = new ArrayDeque<>();
        int cntMax = (queue1.length + queue2.length)*2;
        long q1Tot = 0;
        long tot = 0;
        
        int q1Max = 0;
        int q2Max = 0;
        for(int n : queue1){
            Q1.add(n);
            q1Tot+=n;
            tot+=n;
            
            q1Max = Math.max(q1Max,n);
        }
        for(int n : queue2){
            Q2.add(n);
            tot+=n;
            q2Max = Math.max(q2Max,n);
        }
        // 두 큐의 합을 같게 만들 수 없는 경우
        
        long mid = tot/2;
        if(tot%2==1 || q1Max>mid || q2Max>mid ){
            return -1;
        }
        
        int cnt = 0;
        
        while(Q1.size()>0 && cnt<=cntMax){
            if(q1Tot == mid){
                return cnt;
            }
            else if(q1Tot > tot/2){
                int n = Q1.poll();
                Q2.add(n);
                q1Tot-=n;
                cnt++;
            }else{
                int n = Q2.poll();
                Q1.add(n);
                q1Tot+=n;
                cnt++;
            }
        }
        return -1;
    }
    
    
    public int solution(int[] queue1, int[] queue2) {
        int result  = solve(queue1,queue2);
        
        return result;
    }
}