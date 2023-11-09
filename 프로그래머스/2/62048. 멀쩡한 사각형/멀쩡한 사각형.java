class Solution {
    static long getGCD(long a, long b){

        while(b!=0){
            long tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    
    public long solution(int w, int h) {
        // (w,h)의 최대공약수 구하기
        long gcd = getGCD(w,h);
        
        long miniW = w/gcd;
        long miniH = h/gcd;
        
        long miniCnt = (miniW+miniH-1);
        
        long answer = 1L*w*h - miniCnt*gcd;
        
        
        return answer;
    }
}