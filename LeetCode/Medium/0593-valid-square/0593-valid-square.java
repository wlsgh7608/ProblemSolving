class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        // 정사각형 조건
        // 네 변 길이 같음. 평행
        
        int[][] arr = new int[][]{p1,p2,p3,p4};
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i <4;i++){
            for(int j = i+1;j<4;j++){
                int[] p = arr[i];
                int[] q = arr[j];
                
                // 두 점 사이의 거리 체크
                int dx = p[0]-q[0];
                int dy = p[1]-q[1];
                int dist = dx*dx + dy*dy;
                
                
                hs.add(dist);
            }
        }
        
        if(hs.contains(0)){
            return false;
        }
        
        return hs.size()==2;

    }
}