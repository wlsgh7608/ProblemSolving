import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        StringTokenizer st = new StringTokenizer(path,"/");
        Deque<String> deque = new ArrayDeque<>();

        while(st.hasMoreTokens()){
            String cur = st.nextToken();
            if(cur.equals(".")){
                continue;
            }
            
            if (cur.equals("..")) {
                if(!deque.isEmpty()){
                    deque.pollLast();
                }
            }else{
                deque.addLast(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append("/").append(deque.pollFirst());
        }

        return !sb.isEmpty() ? sb.toString() : "/";
        
    }
}