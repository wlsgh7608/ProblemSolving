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
        List<Time> times = new ArrayList<>();
        for(String time : timePoints){
            StringTokenizer st = new StringTokenizer(time,":");
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
    
            times.add(new Time(h,m));
        }
        Collections.sort(times);
        
        Time first = times.get(0);
        times.add(new Time(first.h+24,first.m));
        
        int minDiff = 24*60;
        for(int i=1;i<times.size();i++){
            Time left = times.get(i-1);
            Time right = times.get(i);
            int diff = Time.diff(left,right);
            minDiff = Math.min(minDiff,diff);
        }
        
        
        return minDiff;
    }
}