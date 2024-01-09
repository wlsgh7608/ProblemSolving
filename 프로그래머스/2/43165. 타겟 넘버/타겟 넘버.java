class Solution {
    
    static int dfs(int depth,int sum,int[] numbers, int target){
        if(depth== numbers.length){
            if(sum== target){
                return 1;
            }
            return 0;
        }
        
        int result = 0;
        int cur = numbers[depth];
        result+= dfs(depth+1,sum-cur,numbers,target);
        result+= dfs(depth+1,sum+cur,numbers,target);
        
        return result;
    }
    public int solution(int[] numbers, int target) {
        return dfs(0,0,numbers,target);
    }
}