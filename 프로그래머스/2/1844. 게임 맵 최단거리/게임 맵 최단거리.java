import java.util.*;
class Solution {
    
    static class Point{
        int x;
        int y;
        int cnt;
        
        public Point(int x, int y, int cnt){
            this.x =x ;
            this.y= y;
            this.cnt =cnt;
        }
    }
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        Queue<Point> Q= new ArrayDeque<>();
        
        Q.add(new Point(0,0,1));
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!Q.isEmpty()){
            Point cur = Q.poll();
            int x = cur.x;
            int y = cur.y;
            int cnt = cur.cnt;
            if(x==N-1&&y==M-1){
                return cnt;
            }
            
            for(int i =0 ; i <4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]||maps[nx][ny]==0){
                    continue;
                    
                }
                visited[nx][ny] = true;
                Q.add(new Point(nx,ny,cnt+1));
            }
            
            
        }
        
        
        return -1;

    }
}