class Solution {
    
    static int[] process(int[][] users,int[] emoticons){
        
        int totPrice = 0;
        int plus = 0;
        for(int[] user : users){
            
            
            int tot = 0;
            for(int i = 0 ; i<N;i++){
                if(arr[i]>=user[0]){
                    int price = emoticons[i];
                    
                    tot+= price*(100-arr[i])*0.01;
                }
            }
            
            if(tot>=user[1]){
                plus++;
            }else{
                totPrice+=tot;
            }
            
        }
        
        return new int[]{plus,totPrice};
        
    }
    
    static void dfs(int idx,int[][] users,int[] emoticons ){
        if(idx == N){
            int[] result = process(users,emoticons);
            if(result[0]>maxPlus){
                maxPlus = result[0];
                maxPrice = result[1];
            }else if(result[0] == maxPlus && result[1]>maxPrice){
                maxPrice = result[1];
            }
            return;
            // 수행
        }
        
        for(int i= 0  ; i<4;i++){
            arr[idx] = percent[i];
            dfs(idx+1,users,emoticons);
        }
        
        
    }
    
    
    static int[] percent = {10,20,30,40};
    static int[] arr;
    
    static int N;
    static int maxPlus;
    static int maxPrice;
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        N = emoticons.length;
        arr = new int[N];
        
        dfs(0,users,emoticons);
        return new int[]{maxPlus,maxPrice};
        
    }
}