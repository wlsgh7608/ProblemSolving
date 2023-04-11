import java.io.*;
import java.util.*;
class Solution {
    
    static void perm(int depth,int flag,int fati,int cnt){
        answer = Math.max(answer,cnt);
        if(depth==N){
            return;
        }
        
        for(int i = 0 ;i < N;i++){
            if((flag & 1<<i)==0){
                if(min_value[i]<= fati && fati-consume[i]>=0)
                perm(depth+1,flag|1<<i,fati-consume[i],cnt+1);
                
            }
        }

    }
    static int N;
    static int[] min_value;
    static int[] consume;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        min_value = new int[N];
        consume = new int[N];
        for(int i = 0; i<N;i++){
            min_value[i]= dungeons[i][0];
            consume[i]= dungeons[i][1];
        }
        
        
        perm(0,0,k,0);
        
        return answer;
    }
}