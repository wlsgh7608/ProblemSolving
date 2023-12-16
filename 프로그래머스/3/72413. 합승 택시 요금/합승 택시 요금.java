import java.util.*;
class Solution {
    
    
    static class Node implements Comparable<Node>{
        int v;
        int cost;
        
        public Node(int v, int cost){
            this.v =v;
            this.cost = cost;
        }
        
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    private int[] getDist(int n,int s,List<Node>[] adjList){
        int[] dist = new int[n+1];
        Arrays.fill(dist,200_000_000);
        dist[s] = 0;
        Queue<Node> Q = new ArrayDeque<>();
        Q.add(new Node(s,0));
        while(!Q.isEmpty()){
            Node cur = Q.poll();
            int v = cur.v;
            int cost = cur.cost;
            
            for(Node next: adjList[v]){
                if(cost+next.cost < dist[next.v]){
                    dist[next.v] = cost+next.cost;
                    Q.add(new Node(next.v,dist[next.v]));
                }
            }
        }
        return dist;
        
    }
    
    
    public int solution(int n, int s, int a, int b, int[][] fares){
        List<Node>[] adjList = new List[n+1];
        for(int i = 1; i <=n;i++){
            adjList[i] = new ArrayList<Node>();
        }
        for(int[] fare :fares){
            int v1 = fare[0];
            int v2 = fare[1];
            int cost = fare[2];
            adjList[v1].add(new Node(v2,cost));
            adjList[v2].add(new Node(v1,cost));
        }
        
        int[] sDist = getDist(n,s,adjList);
        int[] aDist = getDist(n,a,adjList);
        int[] bDist = getDist(n,b,adjList);
        
        int minCost  = 200_000_000 +200_000_000;
        for(int i = 1; i<= n;i++){
            int cost = sDist[i] + aDist[i] + bDist[i];
            minCost = Math.min(minCost,cost);
        }
        
        return minCost;
    }
    
    
    public int solution2(int n, int s, int a, int b, int[][] fares) {
        // s -> m
        // m -> a
        // m -> b 경로 계산
        int[][]dp = new int[n+1][n+1];
        int MAX_COST = 100_000*200;
        for(int[] row : dp){
            Arrays.fill(row,MAX_COST);
        }
        for(int i = 1; i<=n;i++){
            dp[i][i] = 0;
        }
        
        for(int[] fare : fares){
            int v1 = fare[0];
            int v2 = fare[1];
            int cost = fare[2];
            
            dp[v1][v2] = cost;
            dp[v2][v1] = cost;
        }
        
        
        for(int k = 1; k<=n ; k++){
            for(int i = 1; i<=n ; i++){
                for(int j = 1 ; j<=n ; j++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        // for(int[] row : dp){
        //     System.out.println(Arrays.toString(row));
        // }
        int minCost = MAX_COST*2;
        
        for(int i = 1;i<=n;i++){
            int cost = dp[s][i] + dp[i][a] + dp[i][b];
            minCost = Math.min(minCost,cost);
        }
        
        return minCost;
    }
}