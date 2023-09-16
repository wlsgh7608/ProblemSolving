import java.util.*;
class Solution {
    
    
    static int[] simulate(int[][] users, int[] emoticons){
        int cnt =0;
        int tot = 0;
        
        // 유저마다 이모티콘 구매 확인
        for(int[] user : users){
            int price = 0;
            int buyRate = user[0];
            int register = user[1];
            
            
            for(int i = 0 ; i<N;i++){
                // 유저가 정한 할인율 보다 높은 것이 있다면
                // 이모티콘 구매
                if(emotiPercent[i] >=buyRate){
                    price+= emoticons[i]*0.01*(100-emotiPercent[i]);
                }
            }
            // 유저가 이모티콘플러스를 구입하는지 체크
            if(price>=register){
                cnt++;
            }else{
                // 이모티콘 플러스 구입 X
                tot+=price;
            }
            
        }
        
        return new int[]{cnt,tot};
    }
    
    
    static void dfs(int idx,int[][] users,int[] emoticons){
        if(idx==N){
            // 시뮬레이션 시작
            
            int[] result = simulate(users,emoticons);
            int cnt = result[0];
            int tot = result[1];
            if(maxCnt<cnt){
                maxCnt = cnt;
                maxSale = tot;
            }else if(maxCnt==cnt){
                if(maxSale<tot){
                    maxSale = tot;
                }
            }
            return;
        }
        
        for(int i = 0 ; i<4;i++){
            // 이모티콘의 할인율 할당
            emotiPercent[idx] = salePercent[i];
            dfs(idx+1,users,emoticons);
        }
    }
    
    
    static int[] salePercent = {10,20,30,40};
    static int[] emotiPercent;
    static int maxCnt;
    static int maxSale;
    static int N;
    
    public int[] solution(int[][] users, int[] emoticons) {
        N= emoticons.length;
        emotiPercent = new int[N];
        
        // 이모티콘의 크기는 최대 7이다 
        // 브루트포스가 가능하다 => 4^7= 2^14
        dfs(0,users,emoticons);
        
        return new int[]{maxCnt,maxSale};
        
        
    }
}