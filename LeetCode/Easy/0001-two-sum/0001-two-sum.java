class Solution {
    public int[] twoSum(int[] nums, int target) {
        int N = nums.length;
        int[] ans = new int[2];
        
        loop:
        for(int i = 0; i<N-1;i++){
            for(int j = i+1;j<N;j++){
                if(nums[i]+nums[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                    break loop;
                }
            }
        }
        return ans;
        
    }
}