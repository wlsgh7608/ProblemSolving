class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int num : nums){
            if(hs.contains(num)){
                hs.remove(num);
            }else{
                hs.add(num);
            }
            
        }
        
        List<Integer> list = new ArrayList<>();
        for(int n : hs){
            list.add(n);
        }
        return list.get(0);
        
        
    }
}