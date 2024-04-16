class Solution {
    
    
    private boolean isValid(int a, int b, int[] g, int[] s, int[] w, int[] t,long time){
        int N = g.length;
        
        long goldSum= 0;
        long silverSum = 0;
        long totalSum = 0;
        
        
        for(int i =0 ; i<N;i++){
            long iter = 0;
            if(time>t[i]){
                iter++;
            }
            iter += (time-t[i])/(2*t[i]);
            // iter = Math.min(iter,1_000_000_000);
            

            goldSum += Math.min(g[i], w[i]*iter);
            silverSum += Math.min(s[i],w[i]*iter);
            totalSum += Math.min(g[i]+s[i], w[i]*iter);
        }
        // System.out.println(goldSum+" "+silverSum+" "+totalSum);
        if(goldSum < a || silverSum < b || totalSum < a + b){
            return false;
        }
        return true;
        
    }
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        // 금 a, 은 b가 전달되어야 함!
        // 각 도시에 금, 은, 트럭(새 도시만 이동 가능 편도 t, w) 있음
        
        // 나 <---w(금,은) , t---- 도시
        // 금,은 무게의 가성비...?
        int N = g.length;

        
        // 이분탐색 이용
        // 최대 2*10^5(최대 왕복시간) * 2*10^5(최대 크기)
        long lo = 0;
        long hi = 4*(long)Math.pow(10,5)*(long)Math.pow(10,9);
        // hi = Long.MAX_VALUE;
        // System.out.println(hi);

        while(lo<=hi){
            long m = (lo+hi)/2; // overflow 방지
            
            if(isValid(a,b,g,s,w,t,m)){
                hi = m-1;
            }else{
                lo = m+1;
            }
            
            
        }
        
        return lo;
    }
}