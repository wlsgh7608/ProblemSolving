import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static int[] level;
    static int[][] ac;
    static int H;
    static List<Integer>[] adjList;


    static void getTree(int current, int parent) {

        //현재 레벨
        level[current] = level[parent] + 1;
        ac[current][0] = parent; // 내 2^0번째 부모;

        for (int i = 1; i < H; i++) {
            int tmp = ac[current][i - 1]; // 2^(i-1)의 부모 == 0, 1, 2, 4,
            ac[current][i] = ac[tmp][i - 1];
        }


        // 이웃한 노드들에 대하여 레벨, 부모 채우기
        for (int next : adjList[current]) {
            if (next != parent) {
                getTree(next, current);
            }
        }

    }

    static int query(int a, int b) {

        if (level[a] < level[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 높이 맞추기
        for (int i = H; i >= 0; i--) {
            int levelDiff = level[a] - level[b];
            if (1 << i <= levelDiff) {
                a = ac[a][i];
            }
        }

        // LCA 구하기
        if (a == b) {
            return a;
        }

        for (int i = H - 1; i >= 0; i--) {
            // 2^i 번째 부모가 다르다면
            if (ac[a][i] != ac[b][i]) {
                a = ac[a][i];
                b = ac[b][i];
            }
        }
        return ac[a][0];
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];
        level = new int[N + 1]; // 0번째 부모 ~ N번 째 부모
        H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        ac = new int[N + 1][H];

        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }


        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }


        getTree(1, 0);

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = query(a, b);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
