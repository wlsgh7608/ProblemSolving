class Solution {
  public long countBadPairs(int[] nums) {
        int N = nums.length;
        int[] diff = new int[N];

        for(int i = 0 ; i< N; i++){
            diff[i] = nums[i] - i;
        }

        // good pair
        // i - j == nums[i] - nums[j]
        // i - nums[i] == j - nums[j]

        long tot = (long) N * (N - 1) / 2;
        long goodCnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (hm.containsKey(diff[i])) {
                goodCnt += hm.get(diff[i]);
            }
            hm.put(diff[i], hm.getOrDefault(diff[i], 0) + 1);
        }


        return tot - goodCnt;
    }
}