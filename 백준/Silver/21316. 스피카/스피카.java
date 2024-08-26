import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 12;
        int[] arr = new int[N + 1];
        List<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= 12; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 1; i <= 12; i++) {
            if (adjList[i].size() == 3) {
                int cnt = 0;
                for (int next : adjList[i]) {
                    cnt += adjList[next].size();
                }
                if (cnt == 6) {
                    System.out.println(i);
                    break;
                }

            }
        }


    }
}
