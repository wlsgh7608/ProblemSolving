import java.util.*;

class Solution {
    class Homework implements Comparable<Homework>{
        String name;
        int h;
        int m;
        int t;
        
        public Homework(String name,int h, int m,int t){
            this.name = name;
            this.h = h;
            this.m = m;
            this.t = t;
        }
        
        public int compareTo(Homework o){
            if(this.h==o.h){
                return this.m-o.m;
            }
            return this.h-o.h;
        }
        

            
    }
    
    public int getTime(Homework o){
        return o.h*60+o.m;
    }
    
    public String[] solution(String[][] plans) {
        int N = plans.length;
        
        Homework[] homeworks = new Homework[N];
        for(int i = 0; i < N; i++){
            String[] plan = plans[i];
            String name = plan[0];
            StringTokenizer st = new StringTokenizer(plan[1],":");
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(plan[2]);
            homeworks[i] = new Homework(name,h,m,t);            
        }
        Arrays.sort(homeworks);
        
        for(Homework h : homeworks){
            System.out.println(h.h+" "+h.m);
        }
        
        
        
        Stack<Homework> S = new Stack<>();
        
        

        
        
        String[] answer = new String[N];
        int answerIdx = 0;
        
        
        
        
        
        for(int i= 0 ; i <N;i++){
            Homework cur = homeworks[i];
            
            if(i==N-1){
                answer[answerIdx++] = homeworks[i].name;
                break;
            }
            
            Homework next = homeworks[i+1];
            
            int timeDiff = getTime(next) - getTime(cur);
            int remainTime = timeDiff;
            
            if(cur.t <= timeDiff ){
                answer[answerIdx++] = cur.name;                
                remainTime = timeDiff- cur.t;
                System.out.println("END "+cur.name);
                
                while(!S.isEmpty() && remainTime > 0){
                    Homework recentHW = S.peek();
                    if(recentHW.t <= remainTime){
                        answer[answerIdx++] = recentHW.name;
                        S.pop();
                        System.out.println("END "+recentHW.name);
                        remainTime = remainTime-recentHW.t;
                    }else{
                        S.peek().t -= remainTime;
                        remainTime = 0;
                       System.out.println(cur.name+" "+cur.t);
                    }
                }
                
            }else{
                cur.t -= timeDiff;
                System.out.println(cur.name+" "+cur.t);
                S.add(cur);
                            
            }
            
            
        }
        
        
        
        while(!S.isEmpty()){
            answer[answerIdx++] = S.pop().name;
        }
        
        
        
        
        
        
        
        
        
        return answer;
    }
}