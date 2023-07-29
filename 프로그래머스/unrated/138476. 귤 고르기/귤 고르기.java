import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        // hm에 크기,개수
        for (int n : tangerine) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        List<Integer> nums = new ArrayList<>();

        // 리스트에 hm의 개수 담음
        for (int key : hm.keySet()) {
            nums.add(hm.get(key));
        }

        // 내림차순 정렬
        Collections.sort(nums, (o1, o2) -> o2 - o1);;


        // 귤의 개수 k에 담을 수 있는 귤의 개수
        int cnt = 0;
        for (int n : nums) {
            if (k <= 0) {
                break;
            }
            
            k -= n;
            cnt++;

        }


        return cnt;
    }
}