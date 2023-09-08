import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] adjList = new ArrayList[N + 1];
        int[] in = new int[N + 1];
        for(int i = 1;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int prev = -1;
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(j>0){
                    adjList[prev].add(cur);
                    in[cur]++;
                }
                prev = cur;
            }
        }
        Queue<Integer> Q = new ArrayDeque<>();
        for(int i = 1 ; i<=N;i++){
            if(in[i]==0){
                Q.add(i);
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(!Q.isEmpty()){
            int cur = Q.poll();
            sb.append(cur).append("\n");
            cnt++;
            for (int next : adjList[cur]) {
                in[next]--;
                if(in[next]==0){
                    Q.add(next);
                }
            }
        }// end while

        if(cnt==N){
            System.out.println(sb);
        }else{
            System.out.println(0);
        }
    }
}
