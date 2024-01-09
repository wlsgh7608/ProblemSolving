import java.util.*;
class Solution {
    
    static void bfs(int start, int[][] computers,boolean[] visited){
        visited[start] = true;
        
        int N = computers.length;
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(start);
        while(!Q.isEmpty()){
            int cur = Q.poll();
            for(int next = 0 ;next<N;next++){
                if(computers[cur][next]==1 && !visited[next]){
                    visited[next] = true;
                    Q.add(next);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        
        boolean[] visited  = new boolean[n];
        
        int cnt = 0;
        for(int i =0  ;i <n;i++){
            if(!visited[i]){
                bfs(i,computers,visited);
                cnt++;
            }
        }
        return cnt;
    }
}