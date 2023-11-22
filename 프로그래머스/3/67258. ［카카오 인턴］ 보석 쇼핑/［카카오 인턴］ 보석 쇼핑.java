import java.util.*;
class Solution {
    static class Possible implements Comparable<Possible>{
        int s;
        int e;
        int len;
        public Possible(int s,int e){
            this.s = s;
            this.e = e;
            this.len = e-s+1;
        }
        
        public int compareTo(Possible o){
            if(this.len == o.len){
                return this.s-o.s;
            }
            return this.len - o.len;
        }
    }
    
    public int[] solution(String[] gems) {
        
        int p = 0;
        int q = 0;
        
        int N = gems.length;
        HashSet<String> totalSet = new HashSet<>();
        for(String gem: gems){
            totalSet.add(gem);
        }
        
        int totalKind = totalSet.size();

        List<Possible> list  = new ArrayList<>();
        
        
        HashMap<String,Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        while(p<N){
            int curKind = hs.size();
            if(curKind == totalKind){
                list.add(new Possible(p,q));
                String removeGem = gems[p];
                hm.put(removeGem,hm.get(removeGem)-1);
                if(hm.get(removeGem)==0){
                    hs.remove(removeGem);
                }
                p++;
                continue;
            }else{
                if(q==N){
                    break;
                }
                String addGem = gems[q];
                hm.put(addGem,hm.getOrDefault(addGem,0)+1);
                hs.add(addGem);
                q++;
            }
        }
        Collections.sort(list);
        // for(Possible ps : list){
        //     System.out.println("len :"+ps.len+" "+ps.s+" "+ps.e);
        // }
        if(list.size()>0){
        Possible answer = list.get(0);
        
        return new int[]{answer.s+1,answer.e};
            
        }
        return null;
        
    }
}