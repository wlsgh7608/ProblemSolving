class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = numCourses;
        // 이후과목?
        List<Integer>[] preqList = new ArrayList[N];
        int[] preqNum = new int[N];
        
        
        for(int i = 0; i <N;i++){
            preqList[i] = new ArrayList<>();
        }
        
        // 이수과목 p -> q  (q을 들으라면 p을 들어야 함)
        for(int[] preq : prerequisites){
            int q = preq[0];
            int p = preq[1];
            preqList[p].add(q);
            preqNum[q]++;
        }
        
        // 내가 들을 수 있는 과목
        Queue<Integer> Q = new ArrayDeque<>();
        for(int i = 0 ;i<N;i++){
            if(preqNum[i]==0){
                Q.add(i);
            }
        }
        
        while(!Q.isEmpty()){
            int cur = Q.poll();
            for(int next: preqList[cur]){
                if(--preqNum[next]==0){
                    Q.add(next);
                }
            }
        }
        
        // 들을 수 없는 과목이 존재한다면
        for(int i = 0 ; i<N;i++){
            if(preqNum[i]>0){
                return false;
            }
        }
        return true;
        
        
    }
}