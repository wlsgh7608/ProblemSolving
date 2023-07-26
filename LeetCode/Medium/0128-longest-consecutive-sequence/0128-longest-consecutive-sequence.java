class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        // O(n)
        for(int n: nums){
            hs.add(n);
        }
        
        int maxCnt = 0;
        
        for(int n : nums){
            if(hs.contains(n-1)){
                continue;
            }
            
            
            int cnt = 0; 
            
            int findNum = n;
            while(hs.contains(n)){
                hs.remove(n);
                n++;
                cnt++;
            }
            maxCnt = Math.max(maxCnt,cnt);
        }
        return maxCnt;
    }
}