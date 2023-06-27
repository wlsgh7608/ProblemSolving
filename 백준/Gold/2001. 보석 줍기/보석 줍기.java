import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Bridge>[] adjList;
    static boolean[][] visited;

    static class Bridge{
        int v;
        int w;

        public Bridge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Node{
        int n;
        int bit;
        int cnt;

        public Node(int n, int bit,int cnt) {
            this.n = n;
            this.bit = bit;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> jewels = new HashMap<>();
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            jewels.put(n, i);
        }

        adjList = new List[N + 1];
        for(int i = 1;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0 ;i<M;i++){
             st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 양방향
            adjList[a].add(new Bridge(b, c));
            adjList[b].add(new Bridge(a, c));
        }
        visited = new boolean[N + 1][1 << K];

        Queue<Node> Q = new ArrayDeque<>();



        Q.add(new Node(1, 0, 0));
        visited[1][0]= true;

        int result = 0;
        while(!Q.isEmpty()){
            Node cur = Q.poll();
            int n = cur.n;
            int bit = cur.bit;
            int cnt = cur.cnt;
            if(n==1){
                result = Math.max(result,cnt);
            }

            for(Bridge next : adjList[n]){
                if(next.w>=cnt){
                    if(!visited[next.v][bit]){
                        visited[next.v][bit] =true;
                        Q.add(new Node(next.v, bit, cnt));
                    }

                    if(jewels.containsKey(next.v)){
                        int idx = jewels.get(next.v);
                        int newBit = bit | 1 << idx;
                        if(!visited[next.v][newBit]){
                            visited[next.v][newBit] =true;
                            Q.add(new Node(next.v, newBit, cnt + 1));
                        }
                    }
                }
            }
        } // end while
        System.out.println(result);

    }
}
