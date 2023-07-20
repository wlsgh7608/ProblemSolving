import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int getParent(int v) {
        if (parents[v] == v) {
            return v;
        }
        return parents[v] = getParent(parents[v]);
    }

    static int union(int b) {
        b = getParent(b);
        int cost = costs[b];
        parents[b] = 0;
        return cost;

    }

    static int[] parents;
    static int[] costs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        costs = new int[N + 1];

        parents = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            A = getParent(A);
            B = getParent(B);
            if (costs[A] < costs[B]) {
                parents[B] = A;
            } else {
                parents[A] = B;
            }
        }

        // 이제 친구를 사귀어보장
        // 어케하면 될까
        // 주인공을 인덱스 0으로 두고 0인지 아닌지 체크?
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (getParent(i) != 0) {
                result += union(i);
            }
        }
        if (result > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(result);
        }


    }
}
