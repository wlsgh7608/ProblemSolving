import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        boolean[] isUse = new boolean[enemy.length];
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i <enemy.length;i++){
            PQ.add(enemy[i]);
            n = n-enemy[i];
            if(n < 0){
                if(k==0){
                    return i;
                }
                k-=1;
                int maxEnemy = PQ.poll();
                n +=maxEnemy;
            }
        }
        return enemy.length;
        
    }
}