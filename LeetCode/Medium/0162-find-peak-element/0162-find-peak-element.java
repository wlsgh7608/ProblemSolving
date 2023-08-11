class Solution {
    public int findPeakElement(int[] nums) {
        // nums 길이 1000
        // O(logN)
        // 양옆보다 큰 index 찾기
        int N = nums.length;

        // element가 1개인 경우
        if(N==1){
            return 0;
        }
        
        // 맨 왼쪽이 봉우리인 경우
        if(nums[0]>nums[1]){
            return 0;
        }
        // 맨 오른쪽이 봉우리인 경우 
        if( nums[N-1]>nums[N-2]){
            return N-1;
        }
           
        
        int lo = 1;
        int hi = nums.length-2;
        
        int answer = 0;
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(nums[m]>nums[m-1]&& nums[m]>nums[m+1]){
                answer = m;
                break;
            }
            else if(nums[m]<nums[m-1]){
                hi = m-1;
            }else if(nums[m]<nums[m+1]){
                lo = m+1;
            }
            
        }
        return answer;
    }
}