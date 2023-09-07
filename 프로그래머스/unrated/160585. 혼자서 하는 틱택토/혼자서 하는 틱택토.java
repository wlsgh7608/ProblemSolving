class Solution {
    
    
    static boolean isBingo(char c ){
        // row check
        for(int i = 0; i <3;i++){
            boolean flag = true;
            for(int j = 0 ;j<3;j++){
                if(G[i][j] != c){
                    flag =false;
                }
            }
            if(flag){
                return true;
            }
            
        }
        
        // col check
        for(int i = 0 ; i<3;i++){
            boolean flag = true;
            for(int j= 0 ; j <3;j++){
                if(G[j][i]!=c){
                    flag = false;
                }
            }
            if(flag){
                return true;
            }
        }
        // diag check
        boolean isTrue = true;
        for(int i = 0 ; i<3;i++){
            if(G[i][i]!= c){
                isTrue = false;
            }
        }
        if(isTrue){
            return true;
        }
        
        isTrue = true;
        for(int i = 0 ; i<3;i++){
            if(G[i][2-i]!=c){
                isTrue = false;
            }
        }
        if(isTrue){
            return true;
        }
        return false;
        
    }
    
    static char[][] G;
    
    public int solution(String[] board) {
        int oCnt = 0;
        int xCnt = 0;
        G = new char[3][3];
        for(int i = 0 ; i<3;i++){
            for(int j = 0 ; j<3;j++){
                G[i][j] = board[i].charAt(j);
                if(G[i][j]=='O'){
                    oCnt++;
                }else if(G[i][j] =='X'){
                    xCnt++;
                }
            }
        }

        // X의 개수가 더 많거나
        // O의 개수가 X의 개수+1 보다 많은 경우
        if(xCnt>oCnt || oCnt>xCnt+1){
            return 0;
        }
        // 현재 o까지 했을 때
        if(oCnt>xCnt){
            // X 빙고 있으면 안됨
            if(isBingo('X')){
                return 0;
            }
        }
        // 현재 x까지 했을 때
        else if (xCnt == oCnt){
            // O 빙고 있으면 안됨
            if(isBingo('O')){
                return 0;
            }

        }
        
        return 1;
    }
}