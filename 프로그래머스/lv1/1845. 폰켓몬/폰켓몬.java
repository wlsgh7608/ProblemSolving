import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums){
            hs.add(n);
        }
        int max = nums.length/2;
        int ans = hs.size()>max? max : hs.size();
        
        
        return ans;
    }
    
    
    
    
}