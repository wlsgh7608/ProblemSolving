import java.util.*;
class Solution {
    int N;
    int[] A;
    int[] B; 
    
    int maxWinCnt;
    int[] answer;
    int[][] dices;
    
    void diceRoll(int depth, int sum,int[] myDice, List<Integer> sumList){
        if(depth == N/2){            
            sumList.add(sum);
            return;
        }
        
        for(int i= 0 ; i< 6; i++){
            int diceIdx = myDice[depth];
            int[] dice = dices[diceIdx];
            diceRoll(depth+1,sum+dice[i],myDice,sumList);
        }
        
    }
    
    int getWinCnt(List<Integer> list, int target){
        int lo = 0;
        int hi = list.size()-1;
        
        while(lo<=hi){
            int m = (lo+hi)/2;
            if(list.get(m)< target){
                lo = m+1;
            }else{
                hi = m-1;
            }
        }
        // System.out.println("Target : "+target+" cnt : "+lo);
        
        return lo;
    }
    
    
    
    List<Integer> getDiceSum(int[] myDice){
        List<Integer> diceSum = new ArrayList<>();
        diceRoll(0,0,myDice,diceSum);
        return diceSum;

    }
    
    
    void init(int[][] diceArrs){
        dices = diceArrs;
        N = dices.length;
        
        
        A = new int[N/2];
        B = new int[N/2];
        answer = new int[N/2];
    }
    
    int[] clone(int[] arr){
        int[] newArr = new int[N/2];
        for(int i =0 ; i<N/2; i++){
            newArr[i] = arr[i]+1; // 0-base -> 1-base
        }
        return newArr;
    }
    int calculate(){
        HashSet<Integer> hs = new HashSet<>();
        for(int idx : A){
            hs.add(idx);
        }
        int diceIdx = 0;
        for(int i = 0;i < N;i++){
            if(!hs.contains(i)){
                B[diceIdx] = i;
                diceIdx++;
            }
        }
        
        List<Integer> sumListA = getDiceSum(A);
        List<Integer> sumListB = getDiceSum(B);
        
        Collections.sort(sumListB);
        
        int cnt = 0;
        // System.out.println(sumListB);
        for(int sumA :sumListA){
            cnt += getWinCnt(sumListB,sumA);
        }
        return cnt;
        
    }
    
    
    
    void process(int depth,int start,int flag){
        if(depth == N/2){
            int winCnt = calculate();
            if(winCnt> maxWinCnt){
                maxWinCnt = winCnt;
                answer = clone(A);
            }
            // System.out.println(Arrays.toString(A));
            return;
        }
        
        for(int i = start ;i < N;i++){
            //방문 X
            if((flag<<i &1) == 0){
                A[depth] = i;
                process(depth+1, i+1, flag| i<<1);
            }
            
        }
        
        
    }
    
    
    
    public int[] solution(int[][] diceArrs) {
        // 주사위 최대 6^5
        // 6000

        init(diceArrs);
        process(0,0,0);
        
        
        
        return answer;
    }
}