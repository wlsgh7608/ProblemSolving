import java.util.*;
class Solution {
    static class Node{
        int x;
        int y;
        int pX;
        int pY;
        int dist;
        public Node(int x, int y ,int pX,int pY,int dist){
            this.x = x;
            this.y = y;
            this.pX = pX;
            this.pY = pY;
            this.dist = dist;
        }
    }
    static boolean isValid(Queue<Node> Q , char[][] G){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!Q.isEmpty()){
            Node cur = Q.poll();
            int x = cur.x;
            int y = cur.y;
            int pX = cur.pX;
            int pY = cur.pY;
            int dist = cur.dist;
            if(dist==2){
                return true;
            }
            
            for(int i = 0 ;i <4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                
                if(nx<0 ||ny<0 || nx>=G.length|| ny>=G[0].length || G[nx][ny]=='X'){
                    continue;
                }
                
                if(nx==pX && ny==pY){
                    continue;
                    // return false;
                }
                if(G[nx][ny]=='P'){
                    return false;
                }
                Q.add(new Node(nx,ny,pX,pY,dist+1));
                    
            }
        }
        return true;

    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int p = 0;
        for(String[] place : places){
            int N = place.length;
            int M = place[0].length();
            
            char[][] G = new char[N][M];
            
            Queue<Node> Q = new ArrayDeque<>();
            for(int i = 0 ; i<N;i++){
                G[i] = place[i].toCharArray();
                for(int j = 0 ; j<M;j++){
                    if(G[i][j]=='P'){
                        Q.add(new Node(i,j,i,j,0));
                    }
                }
                
            }
            if(isValid(Q,G)){
                answer[p++] = 1;
            }else{
                answer[p++] = 0;
            }
            
        }
        
        
        return answer;
    }
}