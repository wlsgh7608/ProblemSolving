class Solution {
    
    int[][][] dp;
    int[] num;
    boolean[] isMinus;
    boolean[][] visited;

    public int solution(String arr[]) {
        int N = arr.length;
        int opNum = arr.length / 2;
        dp = new int[opNum + 1][opNum + 1][2];
        isMinus = new boolean[opNum];
        visited = new boolean[opNum + 1][opNum + 1];
        num = new int[opNum + 1];
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                int n = Integer.parseInt(arr[i]);
                num[i / 2] = n;
            } else {
                if (arr[i].equals("-")) {
                    isMinus[i / 2] = true;
                }
            }
        }
        getCalc(0, N / 2);
        return dp[0][N / 2][1];
    }

    int[] getCalc(int s, int e) {
        if (visited[s][e]) {
            return dp[s][e];
        }
        visited[s][e] = true;
        if (s == e) {
            int n = num[s];
            return dp[s][e] = new int[]{n, n};
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = s; i < e; i++) {
            int[] left = getCalc(s, i);
            int[] right = getCalc(i + 1, e);

            if (isMinus[i]) {
                int minValue = left[0] - right[1];
                int maxValue = left[1] - right[0];
                min = Math.min(min, minValue);
                max = Math.max(max, maxValue);
            } else {
                int minValue = left[0] + right[0];
                int maxValue = left[1] + right[1];
                min = Math.min(min, minValue);
                max = Math.max(max, maxValue);
            }
        }
        dp[s][e] = new int[]{min, max};
        return dp[s][e];
    }


}