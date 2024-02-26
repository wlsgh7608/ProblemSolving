import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge{
        int v;
        int r;

        public Edge(int v, int r) {
            this.v = v;
            this.r = r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Edge>[] adjList = new List[N + 1];

        for(int i =1 ;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            adjList[v1].add(new Edge(v2, r));
            adjList[v2].add(new Edge(v1, r));
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int cnt = 0;

            Queue<Edge> Queue = new ArrayDeque<>();
            boolean[] visited = new boolean[N + 1];
            visited[v] = true;
            Queue.add(new Edge(v, Integer.MAX_VALUE));
            while(!Queue.isEmpty()){
                Edge cur = Queue.poll();
                if(cur.v!= v && cur.r>= k){
                    cnt++;
                }

                for(Edge next : adjList[cur.v]){
                    if(!visited[next.v]){
                        visited[next.v] = true;
                        int minValue = Math.min(cur.r, next.r);
                        Queue.add(new Edge(next.v, minValue));
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
