class Solution {
    
    
    static void move(int x,int y, int d,int cnt){
        visited[x][y] = true;
        G[x][y] = cnt;
        
        for(int i = 0 ; i<4;i++){
            int nd = (d+i)%4;
            int nx = x+dx[nd];
            int ny = y+dy[nd];
            
            if(nx<0 || ny<0 || nx>=N || ny>= N || visited[nx][ny]){
                continue;
            }

            
            move(nx,ny,nd,cnt+1);
            
            
        }
        
    }
    
    
    static int[] dx;
    static int[] dy;
    static int N;
    
    static int[][] G;
    static boolean[][] visited;
    
    
    public int[][] generateMatrix(int n) {
        
        dx = new int[]{0,1,0,-1};
        dy = new int[]{1,0,-1,0};
        N = n;
        G = new int[n][n];
        visited = new boolean[n][n];
        move(0,0,0,1);
        return G;
    }
}