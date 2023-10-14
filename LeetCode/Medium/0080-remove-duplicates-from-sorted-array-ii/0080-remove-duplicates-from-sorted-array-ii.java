class Solution {
    public int removeDuplicates(int[] nums) {
        boolean isSame = false;
        int prev = -100_000;
        
        int p = 0;
        for(int i = 0; i < nums.length;i++){
            int n = nums[i];
            
            if(prev!=n){
                prev = n;
                nums[p++] = n;
                isSame = false;
            }else if(!isSame){
                    nums[p++] = n;
                
                    isSame = true;
            }
        }
        return p;
        
    }
}