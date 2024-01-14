import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] route;
    static int p = 1;
    static int N;

    static void recur(int idx, int[] tree) {
        int left = idx * 2;
        int right = idx * 2 + 1;
        if (left < N) {
            recur(idx * 2, tree);
        }
        tree[idx] = route[p++];
        if (right < N) {
            recur(idx * 2 + 1, tree);
        }


    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        N = (int) Math.pow(2, K);
        int[] tree = new int[N];
        route = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }
        recur(1, tree);
        StringBuffer sb = new StringBuffer();
        int nextLineIdx = 1;
        int colIdx = 1;
        for (int i = 1; i < N; i++, colIdx++) {
            sb.append(tree[i] + " ");
            if (colIdx == nextLineIdx) {
                sb.append("\n");
                nextLineIdx *= 2;
                colIdx = 0;
            }
        }
        System.out.println(sb);


    }
}
