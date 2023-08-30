class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> dupN = new HashSet<>();
        for(int n : nums){
            if(dupN.contains(n)){
                continue;
            }
            if(hs.contains(n)){
                hs.remove(n);
                dupN.add(n);
            }else{
                hs.add(n);
            }
        }
        int answer = -1;
        for(int n: hs){
            answer = n;
        }
        return answer;
    }
}