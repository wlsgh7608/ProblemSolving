class Solution {
    public int solution(String s) {
        // 길이 1000
        // 회전 1000
        
        int size = s.length();
        int cnt = 0;
        
        for(int i = 0 ; i<size;i++){
            //회전 시킨다.
            String endStr =s.substring(0, i);
            String startStr = s.substring(i);
            String str = startStr + endStr;
            // System.out.println(str);
            
            for(int j= 0 ;j <size;j++){
                str = str.replace("{}","");
                str = str.replace("[]","");
                str = str.replace("()","");

            }            
            if(str.length()==0){
                cnt++;
            }
        }

        return cnt;
        
    }
}