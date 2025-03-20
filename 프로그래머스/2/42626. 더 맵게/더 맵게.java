import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        
        PriorityQueue<Integer> spicies = new PriorityQueue<>();
        for(int  scoville : scovilles){
            spicies.add(scoville);
        }
        
        int cnt = 0;
        while(spicies.size()>=2 || spicies.peek()>=K){
            if(spicies.peek() >= K){
                return cnt;
            }
            
            int first = spicies.poll();
            int second = spicies.poll();
            spicies.add(first+second*2);
            cnt++;
        }
        
        
        
        
        return -1;
    }
}