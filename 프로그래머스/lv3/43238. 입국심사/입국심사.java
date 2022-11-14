class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
		for (int j : times) {
			max = Math.max(max, j);
		}

		long lo = 1;
		long hi = max * n;

		while (lo <= hi) {
			long m = (lo + hi) / 2;

			long canJudge = 0;
			for (int j : times) {
				canJudge += m / j;
			}
			if (canJudge >= n) {
				hi = m - 1;
			} else {
				lo = m + 1;
			}

		}
		return lo;
    }
}