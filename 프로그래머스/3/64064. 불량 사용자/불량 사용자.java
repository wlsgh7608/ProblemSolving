import java.util.*;
class Solution {
    
    
    static boolean isPossible(String userId,String banId){
        boolean isSame = true;
        if(banId.length() !=userId.length()){
            return false;
        }
        
        for(int i = 0; i< userId.length();i++){
            char banChar = banId.charAt(i);
            char userChar = userId.charAt(i);
            if(banChar=='*'){
                continue;
            }

            if(banChar != userChar){
                return false;
            }

        }
        return true;
        
    }
    static void check(int depth,int flag){
        if(depth==N){
            // System.out.println(Integer.bitCount(flag));
            // System.out.println(flag);
            hs.add(flag);
            // if(Integer.bitCount(flag)==N){
            //     answer++;
            // }
            return;
        }
        
        
        for(int i = 0; i< M;i++){
            if((flag & 1<<i) == 0 && banPossible[depth][i]){
                check(depth+1,flag|1<<i);
            }    
        }
               
    }
    
    static boolean[][] banPossible;
    static int N;
    static int M;
    static HashSet<Integer> hs = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        
        M = user_id.length;
        N = banned_id.length;
        
        banPossible = new boolean[N][M];
        
        
        for(int i = 0; i< N; i++){
            for(int j = 0; j < M;j++){
                if(isPossible(user_id[j],banned_id[i])){
                    banPossible[i][j] = true;
                }
            }
        }
        for(boolean[] row: banPossible){
            System.out.println(Arrays.toString(row));
        }
        check(0,0);
        
        
        return hs.size();
    }
}