import java.util.*;

class Solution {
    public int solution(int n) {
        // 자연수 n 표현하기
        // k, k+1, ..., n-1, n을 만족하는 개수 구하기
        int cnt = 0;
        int l = 1;
        int r = 1;
        int sum = 1;
        while (l <= r && r <= n) {
            if (sum == n) {
                cnt++;
            }

            if (sum < n) {
                r++;
                sum += r;
            } else if (sum >= n) {
                sum -= l;
                l++;
            }
        }
        return cnt;
    }
}