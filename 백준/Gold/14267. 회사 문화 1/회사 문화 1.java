import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        List<Integer>[] adjList = new List[N + 1];
        for(int i = 1 ;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i = 2 ; i<=N;i++){
            int n = Integer.parseInt(st.nextToken());
            adjList[n].add(i);
        }

        for(int i =  0;i <M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] +=b;
        }

        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        int[] answer = new int[N + 1];
        while(!Q.isEmpty()){
            int cur = Q.poll();
            answer[cur] += arr[cur];
            for(int next: adjList[cur]){
                if(!visited[next]){
                    visited[next]=  true;
                    answer[next] = answer[cur];
                    Q.add(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N;i++){
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);

    }
}
