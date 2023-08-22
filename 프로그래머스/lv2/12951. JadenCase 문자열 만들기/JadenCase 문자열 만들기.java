import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        
        boolean isFirst = true;
        int len = s.length();
        
        for(int i=0; i<len;i++){
            char c = s.charAt(i);
            
            // 단어의 첫 문자 체크
            if(isFirst){
                sb.append(Character.toUpperCase(c));
            }else{
                sb.append(Character.toLowerCase(c));
            }
            // 현재 공백인지 아닌지 체크
            if(c==' '){
                isFirst = true;
            }else{
                isFirst = false;
            }
        }
        
        return sb.toString();
    }
}