import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void dfs(int v ,int parent){
        visited[v] = true;
        for(int next : adjList[v]){
            if(visited[next] && parent !=next){
                isTree = false;
                continue;
            }
            if(!visited[next]){
                dfs(next, v);
            }
        }
    }

    static boolean[] visited;
    static boolean isTree;
    static List<Integer>[] adjList;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            visited = new boolean[n + 1];
            adjList = new List[n + 1];
            for(int i = 1; i<=n;i++){
                adjList[i] = new ArrayList<>();
            }

            for(int i = 0; i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjList[a].add(b);
                adjList[b].add(a);
            }

            if (n == 0 && m == 0) {
                break;
            }
            int cnt = 0;
            for(int i = 1;i<=n;i++){
                isTree = true;
                if(!visited[i]){
                    dfs(i, -1);
                    if(isTree){
                        cnt++;
                    }
                }
            }

            sb.append("Case " + t + ": ");


            if(cnt==0){
                sb.append("No trees.");
            }else if(cnt==1){
                sb.append("There is one tree.");
            }else{
                sb.append("A forest of " + cnt + " trees.");
            }
            sb.append("\n");


            t++;
        }
        System.out.println(sb);
    }
}
