class Solution {
    public int solution(int[] money) {
        int N = money.length;
        int lastIdx = N-1;

        int[] firstO = new int[N];
        int[] firstX = new int[N];

        firstO[0] =  firstO[1] = money[0];
        firstX[1] = money[1];


        // N => 1_000_000
        for(int i = 2; i<N-1; i++){
            // i 번쨰 집을 털려면 i-1 번째 집을 털면 안됨
            firstO[i] = Math.max(firstO[i - 1], firstO[i - 2] + money[i]);
            firstX[i] = Math.max(firstX[i - 1], firstX[i - 2] + money[i]);
        }
        // 마지막 집은 0번 쨰 집과 연결되어 있음
        firstX[lastIdx] = Math.max(firstX[lastIdx - 1], firstX[lastIdx - 2] + money[lastIdx]);
        firstO[lastIdx] = firstO[lastIdx - 1];

        int maxMoney = Math.max(firstX[lastIdx], firstO[lastIdx]);
        return maxMoney;
    }

}