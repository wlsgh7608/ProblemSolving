import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Wok implements Comparable<Wok>{
        int n;
        int cost;

        public Wok(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Wok o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] wokArr = new int[M];
        int[] minRequired = new int[N + 1];
        Arrays.fill(minRequired, Integer.MAX_VALUE);
        minRequired[0] = 0;

        PriorityQueue<Wok> PQ  = new PriorityQueue<>();

        HashSet<Integer> wokSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=  0 ;i <M;i++){
            int n = Integer.parseInt(st.nextToken());
            wokArr[i] = n;
            // 1개의 wok을 사용해서 만들 수 있는 경우
            wokSet.add(n);
        }

        // 2개의 wok을 이용해서 만들 수 있는 경우
        for(int i = 0 ; i<M;i++){
            for(int j = i+1;j<M;j++){
                int wokA = wokArr[i];
                int wokB = wokArr[j];
                wokSet.add(wokA + wokB);
            }
        }


        PQ.add(new Wok(0, 0));
        Arrays.fill(minRequired, Integer.MAX_VALUE);
        minRequired[0] = 0;

        int ans = -1;
        while(!PQ.isEmpty()){
            Wok cur = PQ.poll();
            int cost = cur.cost;
            int n = cur.n;
            if(n==N){
                ans = cost;
                break;
            }

            // wok을 사용해서 만들 수 있는 경우
            for(int wok: wokSet){
                int next = n + wok;
                if(next <= N && minRequired[next] > cost + 1){
                    minRequired[next] = cost + 1;
                    PQ.add(new Wok(next, cost + 1));
                }
            }
        }
        System.out.println(ans);
    }
}
