import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] next = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            next[i] = Integer.parseInt(br.readLine());
        }

        int maxCnt = 0;
        int maxIdx = 0;
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            visited[i] = true;
            int nextIdx = next[i];
            int cnt = 0;
            while (!visited[nextIdx]) {
                visited[nextIdx] = true;
                cnt++;
                nextIdx = next[nextIdx];
            }
            if (maxCnt < cnt) {
                maxIdx = i;
                maxCnt = cnt;
            }
        }
        System.out.println(maxIdx);


    }
}
