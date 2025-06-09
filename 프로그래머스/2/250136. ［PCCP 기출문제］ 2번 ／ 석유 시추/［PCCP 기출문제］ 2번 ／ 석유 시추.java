import java.util.*;
class Solution {
    
    class Point {
        int x;
        int y;
        public Point(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
    
    int N;
    int M;
    int[][] fuelNum;
    boolean[][] visited;
    HashMap<Integer,Integer> fuelSizeMap;
    
    void init(int[][] land){
        N = land.length;
        M = land[0].length;
        
        fuelNum = new int[N][M];
        visited = new boolean[N][M];
        
        fuelSizeMap = new HashMap<>();
    }
    
    int bfs(int x,int y,int idx,int[][] land){
        Queue<Point> Q = new ArrayDeque<>();
        Q.add(new Point(x,y));
        visited[x][y] = true;
        fuelNum[x][y] = idx;
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        int size = 1;
        
        while(!Q.isEmpty()){
            Point cur = Q.poll();

            for(int i = 0 ;i <4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                
                if(nx<0 ||ny<0|| nx>=N || ny>= M || visited[nx][ny] || land[nx][ny] == 0){
                    continue;
                }
                visited[nx][ny] = true;
                fuelNum[nx][ny] = idx;
                size++;
                Q.add(new Point(nx,ny));

                
            }
                
            
        }
        return size;
    }
    
    public int solution(int[][] land) {
        
        init(land);

        
        int idx = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(land[i][j] == 1 && !visited [i][j]){
                    int size =  bfs(i,j,idx,land);
                    fuelSizeMap.put(idx++,size);                                        
                }
            }
        }
        
        int maxCnt = 0;
        

        
        for(int j = 0; j<M;j++){
            boolean[] v = new boolean[fuelSizeMap.size()];
            int cnt = 0;
            for(int i = 0 ; i<N;i++){
                if(land[i][j] == 1){
                    idx = fuelNum[i][j];
                    if(!v[idx]){
                        cnt+=fuelSizeMap.get(idx);
                        v[idx] = true;
                    }
                }
            }
            maxCnt = Math.max(maxCnt,cnt);
        }
        
        
        
        
        return maxCnt;
    }
}