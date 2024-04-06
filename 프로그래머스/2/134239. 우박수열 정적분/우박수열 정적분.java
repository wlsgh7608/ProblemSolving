import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] getHeight(int k) {
        int cnt = 0;

        List<Integer> graph = new ArrayList<>();
        while (k > 1) {
            graph.add(k);
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
            cnt++;
        }
        graph.add(1);


        int size = graph.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = graph.get(i);
        }
        return arr;

    }

    public double[] solution(int k, int[][] ranges) {
        int[] height = getHeight(k);
        // 횟수
        int cnt = height.length - 1;

        double[] area = new double[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            area[i] = (double) (height[i - 1] + height[i]) / 2;
        }
        System.out.println("N = " + cnt);
        System.out.println(Arrays.toString(area));
        double[] dp = new double[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            dp[i] = dp[i - 1] + area[i];
        }

        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));

        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = cnt + ranges[i][1];

            if (start <= end) {
                double val = dp[end] - dp[start];
//            String format = String.format("%.1f", val);
                answer[i] = val;
            } else {
                answer[i] = -1.0;
            }


        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int k = 6;

//        0,0],[0,-1],[2,-3],[3,-3
        int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        sol.solution(k, ranges);
    }
}