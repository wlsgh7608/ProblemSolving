class Solution {
    public int maximumGap(int[] nums) {
        // 선형시간을 사용하여 구현하기!
        // 시간복잡도 O(N) , 공간복잡도 O(N) 사용하기
        
        // 일반적인 정렬한다? O(NlogN)
        if(nums.length <2){
            return 0;
        }
        // 우리는 Radix Sort 을 이용하여 정렬할 것 
        // Radix 시간복잡도 O(dN)
        // 10개의 버켓 생성
        Queue<Integer>[] buckets = new ArrayDeque[10];
        for(int i = 0 ; i<10;i++){
            buckets[i] = new ArrayDeque<>();
        }
        
        //가장 큰 숫자와 자릿수 찾기 
        int maxNum = 0;
        for(int n : nums){
            maxNum = Math.max(maxNum,n);
        }
        int maxDigit = 0;
        while(maxNum>0){
            maxNum = maxNum/10;
            maxDigit++;
        }
        
        
        List<Integer> list = new ArrayList<>();
        for(int n: nums){
            list.add(n);
        }
        
        
        int div = 10;
        // 일의자리 숫자 -> N의자리까지 for문 돌림
        while(maxDigit-- >0){
            // 버킷에 넣기 
            for(int n : list){
                int remain = (n%div)/(div/10);
                buckets[remain].add(n);
            }
            List<Integer> newList = new ArrayList<>();
            // i 자리 숫자를 기준으로는 정렬이 되어 있음
            //버킷에서 빼서 리스트에 저장
            for(int i =0 ; i <10;i++){
                Queue<Integer> bucket = buckets[i];
                while(!bucket.isEmpty()){
                    newList.add(bucket.poll());
                }
            }
            list = newList;
            div*=10;
        }
        
        Iterator<Integer> it = list.iterator();
        int prev = it.next();
        int maxDiff = 0;
        
        while(it.hasNext()){
            int cur = it.next();
            int diff = cur-prev;
            maxDiff = Math.max(maxDiff,diff);
            prev = cur;
        
        }
        return maxDiff;
    }
}