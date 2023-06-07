import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Rule {
        int s;
        int e;
        int iter;

        public Rule(int s, int e, int iter) {
            this.s = s;
            this.e = e;
            this.iter = iter;
        }
    }

    static boolean isValid(int m) {

        long cnt = 0;
        for (int i = 0; i < M; i++) {
            Rule cur = rules[i];
            if(cur.s>m){
                continue;
            }
            int end = Math.min(cur.e, m);
            cnt+=1;
            cnt += (end - cur.s) / cur.iter;

        }

        if(cnt>=D){
            return true;
        }
        return false;


    }

    static int N;
    static int D;
    static int M;

    static Rule[] rules;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int lo = 1;
        int hi = N;
        rules = new Rule[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int iter = Integer.parseInt(st.nextToken());
            rules[i] = new Rule(s, e, iter);
        }


        while (lo <= hi) {
            int m = (lo + hi) / 2;
//            System.out.print(m);
            if (isValid(m)) {
                hi = m - 1;
            }
            else{
                lo = m+1;
            }

        }
        System.out.println(lo);


    }
}
