import java.util.*;
class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        

        
        int[] newDeliveries = new int[n+1];
        int[] newPickups = new int[n+1];
        
        for(int i = 1; i<=n;i++){
            newDeliveries[i] = deliveries[i-1];
            newPickups[i] = pickups[i-1];
        }
        
        int p = n;
        int q = n;
        
        
        while(p>0 && q>0){
            int remains = cap;
            int maxLoc = 0;
            while(p>0 && remains>0){
                if(newDeliveries[p]>0){
                    maxLoc = Math.max(maxLoc,p);
                    
                    int amount = Math.min(newDeliveries[p],remains); 
                    
                    newDeliveries[p]-= amount;
                    remains-=amount;

                }
                if(newDeliveries[p]==0){
                        p--;
                }
            } // end Deliver
            
            remains = cap;            
             while(q>0 && remains>0){
                if(newPickups[q]>0){
                    maxLoc = Math.max(maxLoc,q);
                    
                    int amount = Math.min(newPickups[q],remains); 
                    remains-=amount;
                    newPickups[q]-= amount;

                }
                 
                 if(newPickups[q]==0){
                     q--;
                 }
            } // end newPickups   
            
            answer+= 2*maxLoc;
        } // end while
            
        while(p>0){
            int maxLoc = 0;
            int remains = cap;
            while(p>0 && remains>0){
                if(newDeliveries[p]>0){
                    maxLoc = Math.max(maxLoc,p);
                    
                    int amount = Math.min(newDeliveries[p],remains); 
                    
                    newDeliveries[p]-= amount;
                    remains-=amount;

                }
                if(newDeliveries[p]==0){
                        p--;
                }
            } // end Deliver            
            answer+= 2*maxLoc;
            
        }
        
        while(q>0){
            int remains = cap;      
            int maxLoc= 0;
             while(q>0 && remains>0){
                if(newPickups[q]>0){
                    maxLoc = Math.max(maxLoc,q);
                    
                    int amount = Math.min(newPickups[q],remains); 
                    remains-=amount;
                    newPickups[q]-= amount;

                }
                 
                 if(newPickups[q]==0){
                     q--;
                 }
            }   
            
            answer+= 2*maxLoc;
        }
        
        
        
        return answer;
    }
}