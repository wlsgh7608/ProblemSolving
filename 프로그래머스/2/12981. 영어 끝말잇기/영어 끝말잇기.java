import java.util.*;
class Solution {
    
    public int[] solution(int n, String[] words) {
        
        HashSet<String> used = new HashSet<>();
        
        
        int round = 1;
        int turn = 1;
        
        char startChar  = words[0].charAt(0);
        
        for(String word : words){
            
            char start = word.charAt(0);
            char end = word.charAt(word.length()-1);
            
            // 끝말잇기를 할 수 없는 경우
            if(startChar != start|| used.contains(word)){
                return new int[]{turn,round};
            }
            
            // 이미 사용한 단어라면
            // if(used.contains(word)){
            //     return new int[]{turn, round};
            // }
            
            startChar = end;
            used.add(word);
            
            // 마지막 사람이라면 round늘리고 다시 진행
            if(turn == n){
                turn = 1;
                round += 1;
            }else{
                
                turn = turn + 1;
            }
        }
        
        // 탈락자가 생기지 않았다면
        return new int[]{0,0};
    }
}