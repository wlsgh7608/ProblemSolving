import java.util.*;
class Solution {
    
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        HashSet<String> used = new HashSet<>();
        
        
        int round = 1;
        int turn = 1;
        
        char startChar  = words[0].charAt(0);
        
        for(String word : words){
            
            char start = word.charAt(0);
            char end = word.charAt(word.length()-1);
            
            if(startChar != start){
                return new int[]{turn,round};
            }
            
            if(used.contains(word)){
                return new int[]{turn, round};
            }
            
            startChar = end;
            used.add(word);
            
            System.out.println(turn+" "+round);
            if(turn == n){
                turn = 1;
                round += 1;
            }else{
                
                turn = turn + 1;
            }
        }
        

        return new int[]{0,0};
    }
}