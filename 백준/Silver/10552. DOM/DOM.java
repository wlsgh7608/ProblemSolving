import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int dfs(int v, int cnt) {
        if (hates[v].size() == 0) {
            return cnt;
        }


        int next = hates[v].get(0);
        int nextChannel = likes[next];
        if (!visited[nextChannel]) {
            visited[nextChannel] = true;
            int ans = dfs(nextChannel, cnt + 1);
            if (ans >= 0) {
                return ans;
            }
        }
        return -1;


    }

    static int[] likes;
    static boolean[] visited;
    static List<Integer>[] hates;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken()) - 1;

        visited = new boolean[M];
        hates = new List[M]; // 해당 채널을 싫어하는 노인 리스트
        for (int i = 0; i < M; i++) {
            hates[i] = new ArrayList<>();
        }
        likes = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            likes[i] = a;
            hates[b].add(i);
        }
        for (int i = 0; i < M; i++) {
            Collections.sort(hates[i]);
        }
        visited[P] = true;
        int result = dfs(P, 0);
        System.out.println(result);

    }
}
