import java.util.ArrayList;
import java.util.List;

public class Solution {


    int answer = 0;
    boolean[] visited;

    private void dfs(int sheep, int wolf, int[] info, int[][] edges) {
        if (sheep <= wolf) {
            return;
        }

        answer = Math.max(answer, sheep);

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (visited[from] && !visited[to]) {
                visited[to] = true;
                if (info[to] == 0) {
                    dfs(sheep + 1, wolf, info, edges);
                } else {
                    dfs(sheep, wolf + 1, info, edges);
                }
                visited[to] = false;
            }
        }
    }

    public int solution(int[] info, int[][] edges) {
        int N = info.length;

        visited = new boolean[N];
        visited[0] = true;

        dfs(1, 0, info, edges);
        

        return answer;
    }
}
