class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int i = 1; i<= yellow;i++){
            for(int j = 1;i*j<=yellow;j++){
                if(i*j==yellow){
                    if(2*(i+2)+ 2*j == brown){
                        return new int[]{j+2,i+2};
                    }
                }
            }
        }
        
        return null;
    }
}