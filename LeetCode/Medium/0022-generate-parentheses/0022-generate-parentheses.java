import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    
    
    void dfs(int left,int right,int n, String str,List<String> result){
        if(left == n && right == n){
            result.add(str);
            return;
        }
        if(left < n){
            dfs(left+1,right,n,str+"(",result);
        }
        if(right < left){
            dfs(left,right+1,n,str+")",result);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        // n개의 괄호 리스트 출력하기

        // 1 : ()
        // 2 : ()(), (())
        // 3 : ((())), (()()), (())(), ()(()), ()()()

        List<String> result = new ArrayList<>();
        dfs(0,0,n,"",result);

        return result;

    }
}