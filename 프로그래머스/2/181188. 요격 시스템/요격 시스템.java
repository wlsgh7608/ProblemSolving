import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        // 요격을 e위치를 기준으로 정렬
        Comparator<int[]> TargetComparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                // if(o1[1]==o2[1]){
                //     return o1[0]-o2[0];
                // }
                return o1[1]-o2[1];
            }
        };
        Arrays.sort(targets,TargetComparator);
        
        int end = -1;
        int cnt = 0;
        for(int[] target: targets){
            int targetStart = target[0];
            int targetEnd = target[1];
        
            if(targetStart>=end){
                end = targetEnd;
                cnt++;
            }
        
        }
        
        return cnt;
    }
}