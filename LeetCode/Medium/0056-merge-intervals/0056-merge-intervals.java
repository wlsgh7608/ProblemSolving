class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        
        Comparator<int[]> myComparator = new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                // 종료 오름차순
                return o1[0]-o2[0];
            }
        };
        
        
        Arrays.sort(intervals,myComparator);
                
        int start = intervals[0][0];
        int end = intervals[0][1];
        

        
        for(int[] interval : intervals){
            int s = interval[0];
            int e = interval[1];
            
            if(s<=end){
                end = end > e? end: e;
            }else{
                list.add(new int[]{start,end});
                start = s;
                end = e;
            }
        }
        // last element
        list.add(new int[]{start,end});
        
        int size = list.size();
        int[][] result = new int[size][2];
        for(int i = 0 ; i<size;i++){
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        
        return result;
        
        
    }
}