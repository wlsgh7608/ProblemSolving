import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // 야근 -> 피로도
        // 피로도 = (남은 작업량^2)
        long answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int work : works) {
            PQ.add(work);
        }

        while (n > 0 && !PQ.isEmpty()) {
            int cur = PQ.poll();
            int diff = PQ.isEmpty() ? cur : cur - PQ.peek();

            if (diff == 0) {
                n -= 1;

                int remainWork = cur - 1;
                if (remainWork > 0) {
                    PQ.add(cur - 1);
                }
            } else {
                int workTime = Math.min(n, diff);
                n -= workTime;
                int remainWork = cur - workTime;
                if (remainWork > 0) {
                    PQ.add(remainWork);
                }
            }
        }

        long result = 0;

        while (!PQ.isEmpty()) {
            int remainTime = PQ.poll();
            result += 1L * remainTime * remainTime;
        }


        return result;
    }


}