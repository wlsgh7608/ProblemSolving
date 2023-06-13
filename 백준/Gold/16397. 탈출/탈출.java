import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Try{
        int n;
        int t;

        public Try(int n, int t) {
            this.n = n;
            this.t = t;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());


        Queue<Try> Q = new ArrayDeque<>();
        Q.add(new Try(N, 0));
        int ans = -1;
        boolean[] visited = new boolean[100_000];
        visited[N]= true;

        while(!Q.isEmpty()){
            Try cur = Q.poll();
            if(cur.t>T){
                break;
            }
            if(cur.n==G){
                ans = cur.t;
                break;
            }


            if(cur.n<99999 && !visited[cur.n+1]){
                visited[cur.n+1]= true;
                Q.add(new Try(cur.n + 1, cur.t + 1));
            }

            if(cur.n<50000){
                int temp = cur.n*2;
                int cnt = 0;
                int maxD = 0;
                while(temp>0){
                    temp/=10;
                    maxD = (int)Math.pow(10,cnt);
                    cnt++;
                }

                int next = cur.n*2;

                if(next>0){
                    next-=maxD;
                }
                if(!visited[next]){
                    visited[next] = true;
                    Q.add(new Try(next, cur.t + 1));
                }

            }



        } // end while
        if(ans>-1){
            System.out.println(ans);
        }else{
            System.out.println("ANG");
        }




    }
}
