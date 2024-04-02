class Solution {
    
    private void init(String[] board){
        
    }
    
    private boolean rowCheck(char[][] cBoard, char c){
        for(int i = 0; i < 3; i++){
            int cnt = 0;
            for(int j =0; j<3 ;j++){
                if(cBoard[i][j] == c){
                    cnt++;
                }
            }
            if(cnt==3){
                return true;
            }
        }
        return false;
    }
    
    private boolean colCheck(char[][] board, char c){
        // 세로 체크
        for(int j = 0; j<3;j++){
            int cnt = 0;
            for(int i = 0; i<3;i++){
                if(board[i][j] == c){
                    cnt++;
                }
            }
            if(cnt==3){
                return true;   
            }
        }
        return false;
    }
    
    private boolean diagCheck(char[][] board, char c){
        // 대각선 체크
        // 오른쪽 아래 대각선
        int cnt = 0;
        for(int i = 0 ;i<3;i++){
            if(board[i][i] == c){
                cnt++;
            }
        }
        if(cnt==3){
            return true;
        }
        
        
        // 오른쪽 위 대각선 체크
        cnt = 0;
        for(int i =0 ; i<3;i++){
            if(board[i][2-i]==c){
                cnt++;
            }
        }
        if(cnt==3){
            return true;
        }
        return false;
    }
    
    
    private boolean isBingo(char[][] board, char c){
        // 가로 체크
        if(rowCheck(board,c)){
            return true;
        }
        // 세로 체크
        if(colCheck(board,c)){
            return true;
        }
        // 대각선 체크
        if(diagCheck(board,c)){
            return true;
        }
        return false;
        
    }
    
    
    private boolean isOk(char[][] board){
        int xCnt = 0;
        int oCnt = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == 'X'){
                    xCnt++;
                }else if(board[i][j] == 'O'){
                    oCnt++;
                }
            }
        }
        
        // 선공 O, 후공 X
        // X의 개수가 O의 개수보다 많으면 안됨
        // O의 개수가 X의 개수보다 2이상 많으면 안됨
        if(xCnt > oCnt){
            return false;
        }
        if(oCnt >= xCnt + 2){
            return false;
        }
        
        // 빙고가 완성 경우
       
        boolean isXBingo = isBingo(board,'X');
        boolean isOBingo = isBingo(board,'O');
        
        System.out.println("xBingo = " + isXBingo+" "+xCnt);
        System.out.println("oBingo = " + isOBingo+" "+oCnt);
         // O빙고 완성 했는데도 X가 진행 되면 안됨
        if(isOBingo && xCnt == oCnt){
            return false;
        }
        // X빙고 완성 했는데도 O가 진행 되면 안됨
        if(isXBingo && oCnt > xCnt){
            return false;
        }
        return true;
    }
    
    public int solution(String[] board) {
        char[][] cBoard = new char[3][3];
        for(int i = 0; i<3;i++){
            cBoard[i] = board[i].toCharArray(); 
        }
        
        boolean isPossible = isOk(cBoard);
        if(isPossible){
            return 1;
        }
        return 0;
    }
}