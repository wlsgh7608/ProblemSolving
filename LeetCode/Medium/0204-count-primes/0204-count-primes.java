class Solution {
    public int countPrimes(int n) {
        // n보다 작은 소수 찾기
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        
        // 에라토스체네스의 해
        // 소수가 아닌 것 false로 변경
        for(int i = 2; i <=n;i++){
            for(int j =2;i*j<=n;j++){
                int num = i*j;
                isPrime[num] = false;
            }
        }
        
        // 개수 체크
        int cnt = 0;
        for(int i = 2; i<n;i++){
            if(isPrime[i]){
                cnt++;
            }
        }
        return cnt;
        
    }
}