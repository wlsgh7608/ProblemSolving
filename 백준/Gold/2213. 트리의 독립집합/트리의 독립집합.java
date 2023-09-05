import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static List<Integer>[] adjList;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    static void getCount(int v) {
        visited[v] = true;

        dp[v][0] = 0;
        dp[v][1] = arr[v];

        for (int next : adjList[v]) {
            if (!visited[next]) {
                //use
                getCount(next);

                dp[v][1] += dp[next][0];
                //not use
                dp[v][0] += Math.max(dp[next][1], dp[next][0]);
            }
        }
    }


    static void trace(int v,boolean prev) {
        visited[v] = true;

        boolean isUse = false;
        if (!prev && dp[v][1] > dp[v][0]) {
            answer.add(v);
            isUse = true;
        }

        for (int next : adjList[v]) {
            if (!visited[next]) {
                // 사용한 경우가 더 높은 경우
                trace(next,isUse);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        adjList = new List[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2]; // (번호,포함 여부)


        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        // end input

        // 루트는 1 번째로 하자
        getCount(1);
        Arrays.fill(visited, false);
        trace(1,false);
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        if (dp[1][0] > dp[1][1]) {
            sb.append(dp[1][0]).append("\n");
        } else {
            sb.append(dp[1][1]).append("\n");
        }
        for (int v : answer) {
            sb.append(v + " ");
        }
        System.out.println(sb);
    }
}
