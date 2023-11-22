import java.util.*;
class Solution {
    static class Car implements Comparable<Car>{
        int x;
        int y;
        int d;
        int cost;
        
        public Car(int x, int y ,int d, int cost){
            this.x = x;
            this.y = y;
            this.d = d;
            this.cost = cost;
        }
        
        public int compareTo(Car o){
            return this.cost - o.cost;
        }
    }
    public int solution(int[][] board) {
        int N = board.length;
        int M = board[0].length;
        int [][][] minCost = new int[N][M][4];
        for(int[][] G : minCost){
            for(int [] row : G){
                Arrays.fill(row,25*25*500);
            }
        }
        

        // 아래 오른 위 왼 
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        PriorityQueue<Car> PQ = new PriorityQueue<>();
        
        if(board[1][0]==0){
            minCost[1][0][0] = 100;
            PQ.add(new Car(1,0,0,100));
        }
        if(board[0][1]==0){
            minCost[0][1][1] = 100;
            PQ.add(new Car(0,1,1,100));
        }
        
        while(!PQ.isEmpty()){
            Car cur = PQ.poll();
            // System.out.println(cur.x+ " "+cur.y+ " "+cur.cost);
            
            for(int i = 0 ; i<4;i++){
                if(i== (cur.d+2)%4){
                    continue;
                }
                int cost = cur.cost;
                if(i == cur.d){
                    cost+=100; // 직진일 때는 100원
                }else{
                    cost+=600; // 꺾을 때는 코너 + 직선비용 = 600
                }
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                
                if(nx<0 || ny<0|| nx>=N|| ny>=M|| board[nx][ny]==1){
                    continue;
                }
                
                if(minCost[nx][ny][i] > cost){
                    minCost[nx][ny][i] = cost;
                    PQ.add(new Car(nx,ny,i,cost));
                }
            }
        }
        int[] end = minCost[N-1][M-1];
        return Math.min(end[0],end[1]);
         
    }
}