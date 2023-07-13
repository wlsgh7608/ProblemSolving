class Solution {
    
    
    static void dfs(int num1,int num2,int cnt){
        maxLen = Math.max(maxLen,cnt);
        
        int sum = num1+num2;
        if(hs.contains(sum)){
            dfs(num2,sum,cnt+1);
        }
        
        
    }
    static int maxLen;
    static int N;
    static HashSet<Integer> hs;
    static int[] array;
    
    public int lenLongestFibSubseq(int[] arr) {
        N = arr.length;
        hs = new HashSet<>();
        array = arr;
        maxLen = 0;
        
        for(int n : arr){
            hs.add(n);
        }
        
        
        for(int i = 0 ; i<N-1;i++){
            for(int j = i+1;j<N;j++){
                int sum = arr[i]+arr[j];
                if(hs.contains(sum)){
                 dfs(arr[j],sum,1);
                }
            }
        }
        if(maxLen>0){
            maxLen+=2;
        }
        
        return maxLen;

        
    }
}