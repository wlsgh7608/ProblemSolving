class Solution {
    public int solution(int n) {

        //  n은 1,000,000 이하의 자연수
        int oneCnt = Integer.bitCount(n);

        //2^20 = 1,048,576
        final int MAX = 1_048_576 - 1;

        for (int i = n + 1; i <= MAX; i++) {
            if (oneCnt == Integer.bitCount(i)) {
                return i;
            }
        }

        return -1;
    }

}