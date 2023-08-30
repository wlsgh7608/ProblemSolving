class Solution {
    public int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;
        int thrice = 0;
        
        for(int n : nums){
            twice = twice | ( once & n);
            once = once ^ n;
            thrice = once & twice;
            once = once & (~thrice);
            twice = twice & (~thrice);    
        }
        
        return once;
    }
}