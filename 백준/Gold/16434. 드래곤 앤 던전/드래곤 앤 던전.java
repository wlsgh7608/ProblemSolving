import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Event {
        boolean isMonster;
        long atk;
        long hp;

        public Event(boolean isMonster, long atk, long hp) {
            this.isMonster = isMonster;
            this.atk = atk;
            this.hp = hp;
        }
    }
    static boolean isTrue(long atk, long maxHp){
        long  curHp = maxHp;
        for(Event e:events){
            if(e.isMonster){
                int iter = (int) Math.ceil(1.0 * e.hp / atk) -1;
                curHp -= e.atk*iter;
                if(curHp<=0){
                    return  false;
                }
            }else{
                curHp = Math.min(maxHp,curHp + e.hp);
                atk += e.atk;
            }
        }
        return true;

    }

    static Event[] events;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());
        events = new Event[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            boolean isMonster = true;
            if (a == 1) {
                isMonster = true;
            } else {
                isMonster = false;
            }
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            events[i] = new Event(isMonster, b, c);
        }
        long lo = 0;
        long hi = 1_000_000L*1_000_000L*123456L;
        while(lo<=hi){
            long m = (lo+hi)/2;
            if (isTrue(atk, m)) {
                hi = m-1;
            }else{
                lo = m+1;
            }
        }
        System.out.println(lo);

    }
}
