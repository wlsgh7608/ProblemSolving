import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int[] dfs(int v) {
        visited[v] = true;
        int no = 0;
        int yes = 1;

        for (int next : adjList[v]) {
            if (!visited[next]) {
                int[] result = dfs(next);
                no += result[1];
                yes += Math.min(result[0],result[1]);
            }
        }
        return new int[]{no, yes };
    }


    static boolean[] visited;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adjList = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }


        visited = new boolean[N + 1];


        int[] result = dfs(1);
        int minResult = Math.min(result[0], result[1]);

        System.out.println(minResult);
    }
}
