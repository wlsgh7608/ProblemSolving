import java.util.*;
class Solution {
    
    static class Time implements Comparable<Time>{
        int h;
        int m;
        
        
        public Time(int h, int m){
            this.h = h;
            this.m = m;
        }
        
        static int diff(Time a,Time b){
            int aMinute = 60*a.h+a.m;
            int bMinute = 60*b.h+b.m;
            
            return Math.abs(aMinute-bMinute);
        }
        
        public int compareTo(Time o){
            if(this.h ==o.h){
                return this.m - o.m;
            }
            return this.h - o.h;
        }
        
        
    }
    
    
    
    public int findMinDifference(List<String> timePoints) {
        
        int N  = timePoints.size();
        Time[] times = new Time[N];
        
        int p = 0;
        for(String time : timePoints){
            StringTokenizer st = new StringTokenizer(time,":");
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
    
            times[p++] = new Time(h,m);
            
        }
        Arrays.sort(times);
        int minDiff = 24*60;
        for(int i=1;i<N;i++){
            Time left = times[i-1];
            Time right = times[i];
            int diff = Time.diff(left,right);
            minDiff = Math.min(minDiff,diff);
        }
        Time firstPlus24 = new Time(times[0].h+24, times[0].m);
        minDiff = Math.min(minDiff,Time.diff(firstPlus24,times[N-1]));
        
        
        
        return minDiff;
    }
}