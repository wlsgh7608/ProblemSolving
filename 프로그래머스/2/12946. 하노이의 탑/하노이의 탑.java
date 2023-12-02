import java.util.*;
class Solution {
    static void move(int start,int end,int other, int size,List<int[]> routes){
        if(size==0){
            return;
        }
        move(start,other,end,size-1,routes);
        routes.add(new int[]{start,end});
        move(other,end,start,size-1,routes);
    }
    public int[][] solution(int n) {
        List<int[]> routes = new ArrayList<>();
        move(1,3,2,n,routes);
        int N = routes.size();
        int[][] answer = new int[N][2];
        for(int i = 0; i < N; i++){
            answer[i] = routes.get(i);
        }
        return answer;
    }
}