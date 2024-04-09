import java.util.*;
class Solution {
    
    public int solution(int cacheSize, String[] cities) {
        // 가장 나중에 사용했던 페이지를 교체
        HashMap<String,Integer> hm = new HashMap<>();
        Queue<String> Q = new ArrayDeque<>();
        int N = cities.length;
        
        int tot = 0;
        
        for(int time = 0; time < N;time++){
            String city = cities[time];
            city = city.toLowerCase();
            //캐쉬에 있는 경우 hit
            if(hm.containsKey(city)){
                Q.add(city);
                hm.put(city,hm.get(city) +1);
                
                tot+=1;
            }else{
                // 캐쉬에 없는 경우
                // 캐쉬에 저장 할 수 있는 경우
                if(hm.size()<cacheSize){
                    Q.add(city);
                    hm.put(city,hm.getOrDefault(city,0)+1);
                    tot+=5;
                }else{
                    // 캐시의 page 교체
                    while(!Q.isEmpty()){
                        String key = Q.poll();
                        hm.put(key,hm.get(key)-1);
                        int keyCnt = hm.get(key);
                        if(keyCnt==0){
                            
                            hm.remove(key);
                            Q.add(city);                            
                            hm.put(city,1);
                            break;
                        }
                    }
                    tot+=5;

                }
            }
        }
        return tot;
    }
}