import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int dfs(int v){
        dfsn[v] = ++cnt;
        S.add(v);

        int result = dfsn[v];
        for(int next : adjList[v]){
            // 방문 X
            if(dfsn[next]==0){
                result = Math.min(result,dfs(next));
            }else if (!finished[next]){ // 방문 but 끝나지 않음
                result = Math.min(result,dfsn[next]);
            }
        }

        if(result==dfsn[v]){
            List<Integer> scc = new ArrayList<>();
            while(!S.isEmpty()){
                int cur = S.pop();
                finished[cur]= true;
                scc.add(cur);

                if(cur==v){
                    break;
                }
            }
            Collections.sort(scc);
            sccs.add(scc);
        }
        return result;
    }

    static int N,K;
    static int cnt =0;
    static List<Integer>[] adjList;
    static int[] dfsn;
    static boolean[] finished;
    static Stack<Integer> S = new Stack<>();
    static List<List<Integer>> sccs;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dfsn = new int[N+1];
        finished = new boolean[N+1];

        adjList = new ArrayList[N+1];

        for(int i = 1 ;i<=N;i++){
            adjList[i]= new ArrayList<>();
        }

        for(int i = 0; i<K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
        }
        sccs = new ArrayList<>();

        for(int i = 1;i<=N;i++){
            if(dfsn[i]==0){
                dfs(i);
            }
        }
        Collections.sort(sccs,(o1, o2) -> o1.get(0)-o2.get(0));

        StringBuilder sb = new StringBuilder();
        sb.append(sccs.size()).append("\n");
        for(List<Integer> scc :sccs){
            for(int n : scc){
                sb.append(n+" ");
            }
            sb.append(-1).append("\n");
        }
        System.out.println(sb);

    }
}
