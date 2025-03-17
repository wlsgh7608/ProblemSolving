import java.util.*;
class Solution {    
    static class Stock {
        int time;
        int price;
        
        public Stock(int time, int price){
            this.time = time;
            this.price = price;
        }
    }
    
    public int[] solution(int[] prices) {
        Stack<Stock> S = new Stack<>();
        
        int N = prices.length;
        int[] answer = new int [N];
        
        for(int i =0 ; i< N; i++){
            int cur = prices[i];
            while(! S.isEmpty() && S.peek().price > cur){
                Stock stock = S.pop();
                answer[stock.time] = i-stock.time;
            }
            S.add(new Stock(i,cur));
        }
        
        while(! S.isEmpty() ){
            Stock stock = S.pop();
            answer[stock.time] = N-1-stock.time;
        }        
        
        return answer;
    }
}