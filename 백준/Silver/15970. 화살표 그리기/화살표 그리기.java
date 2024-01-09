import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] colors = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            colors[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            colors[col].add(loc);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(colors[i]);
        }


        int result = 0;
        for (int i = 1; i <= N; i++) {
            int M = colors[i].size();
            List<Integer> color = colors[i];

            for (int j = 0; j < M; j++) {
                int cur = color.get(j);
                if (j == 0) {
                    result += color.get(j + 1) - cur;
                } else if (j == M - 1) {
                    result += cur - color.get(j - 1);
                } else {
                    int left = cur - color.get(j - 1);
                    int right = color.get(j + 1) - cur;
                    result += Math.min(left, right);
                }
            }
        }
        System.out.println(result);
    }
}
