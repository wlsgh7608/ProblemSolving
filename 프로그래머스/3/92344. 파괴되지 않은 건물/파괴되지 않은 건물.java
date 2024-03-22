import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] dG = new int [N][M];
        
        for(int[] row : skill){
            int type = row[0];
            int x1 = row[1];
            int y1 = row[2];
            int x2 = row[3];
            int y2 = row[4];
            int degree = row[5];
            if(type==1){
                degree *=-1;
            }
            dG[x1][y1] += degree;
            if(x2+1<N){
                dG[x2+1][y1] -= degree;
            }
            if(y2+1<M){
                dG[x1][y2+1] -= degree;
            }
            if(x2+1<N&&y2+1<M){
                dG[x2+1][y2+1] += degree;
            }
        }
        
        for(int i = 1; i<N;i++){
            for(int j = 0; j<M;j++){
                dG[i][j] += dG[i-1][j];
            }
        }
        
        for(int j = 1 ; j<M;j++){
            for (int i = 0 ; i <N;i++){
                dG[i][j] += dG[i][j-1];
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i<N;i++){
            for(int j =0; j<M;j++){
                
            
            if(board[i][j]+dG[i][j]>0){
                answer++;
            }
                }
        }
        
   
        return answer;
    }
}