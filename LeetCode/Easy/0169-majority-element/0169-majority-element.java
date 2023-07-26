class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int maxCnt = 0;
        int maxN = 0;
        for(int n : nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
            
            if(maxCnt<hm.get(n)){
                maxCnt=hm.get(n);
                maxN = n;
            }
        }
        return maxN;
        
    }
}