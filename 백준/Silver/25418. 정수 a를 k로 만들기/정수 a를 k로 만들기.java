import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[1000001];
        int cnt = 0;
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(A);
        visited[A] = true;
        queue:
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i=0; i<size; i++){
                int cur = Q.poll();
                if(cur == K){
                    break queue;
                }
                if(cur+1<=1_000_000 && !visited[cur+1]){
                    Q.add(cur+1);
                    visited[cur+1] = true;

                }
                if(cur*2 <= 1_000_000 && !visited[cur*2]){
                    Q.add(cur*2);
                    visited[cur*2] = true;
                }
            }
            cnt++;
        }
        System.out.println(cnt);


    }
}
