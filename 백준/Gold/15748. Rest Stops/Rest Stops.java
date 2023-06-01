import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Rest  implements  Comparable<Rest>{
        int x;
        int t;

        public Rest(int x, int t) {
            this.x = x;
            this.t = t;
        }

        @Override
        public int compareTo(Rest o) {
            if(o.t==this.t){
                return this.x - o.x;
            }
            return o.t - this.t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int rF = Integer.parseInt(st.nextToken());
        int rB = Integer.parseInt(st.nextToken());

        Rest[] rests = new Rest[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            rests[i] = new Rest(x, t);
        }
        Arrays.sort(rests);
        int curLoc = 0;
        long result = 0;

        for(Rest rest : rests){
            if(rest.x > curLoc){
                long time = (long)(rest.x - curLoc) * (rF - rB);
                result += time * rest.t;
                curLoc = rest.x;
            }
        }
        System.out.println(result);






    }
}
