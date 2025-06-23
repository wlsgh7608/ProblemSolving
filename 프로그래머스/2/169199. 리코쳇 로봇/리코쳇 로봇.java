import java.util.*;

class Solution {
    static class Node{
        int x;
        int y;
        int cnt;
        
        public Node(int x, int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt =cnt;
        }
    }
    
    // 멈출 수 있는지 여부
    static boolean isStop(int x, int y,int d){
        int nx = x+dx[d];
        int ny = y+dy[d];
        if(nx==-1 || nx== N || ny==-1 || ny==M|| G[nx][ny]=='D'){
            return true;
        }
        
        return false;
        
    }
    
    
    static int N;
    static int M;
    static char[][] G;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    
    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        
        visited= new boolean[N][M];
        Queue<Node> Q = new ArrayDeque<>();
        G = new char[N][M];
        Node end= null;
        
        for(int i =0 ; i<N;i++){
            for(int j = 0 ; j<M;j++){
                G[i][j] = board[i].charAt(j);
                if(G[i][j] == 'R'){
                    Q.add(new Node(i,j,0));
                    visited[i][j] = true;
                }else if (G[i][j]=='G'){
                    end = new Node(i,j,0);
                }
            }
        }
        
        while(!Q.isEmpty()){
            Node cur = Q.poll();
            //골에 도달 
            if(cur.x==end.x && cur.y==end.y){
                return cur.cnt;
            }
            
            for(int i = 0 ; i<4;i++){
                int nx = cur.x ;
                int ny = cur.y ;
                while(true){
                    
                    if(isStop(nx,ny,i)){
                        if(!visited[nx][ny]){
                            visited[nx][ny] = true;
                            Q.add(new Node(nx,ny,cur.cnt+1));
                        }
                        break;
                    }else{
                        nx += dx[i];
                        ny += dy[i];   
                    }

                }
            }
        }
        
        
        
        return -1;
    }
}