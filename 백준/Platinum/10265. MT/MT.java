import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class SCC {
        int n;
        int v;

        public SCC(int n, int v) {
            this.n = n;
            this.v = v;
        }

        @Override
        public String toString() {
            return "SCC{" +
                    "n=" + n +
                    ", v=" + v +
                    '}';
        }
    }


    static SCC reverseBFS(List<Integer> scc) {
        Queue<Integer> Q = new ArrayDeque<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int n : scc) {
            Q.add(n);
            visited[n] = true;
        }
        int minCircle = scc.size();
        int var = 0;

        while (!Q.isEmpty()) {
            int cur = Q.poll();
            ans.add(nums[cur]);

            for (int next : reverse[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    nums[next] = nums[cur] + 1;
                    var++;
                    Q.add(next);
                }
            }
        }
        return new SCC(minCircle, var);
    }


    static int getMember(int v) {
        dfsn[v] = sn++;
        S.add(v);
        int next = follows[v];

        int result = dfsn[v];
        // 아직 방문 X
        if (dfsn[next] == 0) {
            result = Math.min(result, getMember(next));
        } else if (!finished[next]) {
            // 끝나지 않음
            result = Math.min(result, dfsn[next]);
        }

        // 자기 자신이 root  SCC 발견!
        if (result == dfsn[v]) {
            // 자기자신 나올때까지 pop
            List<Integer> scc = new ArrayList<>();
            while (!S.isEmpty()) {
                int cur = S.pop();
                scc.add(cur);

                finished[cur] = true;
                if (cur == v) {
                    break;
                }
            }
            S = new Stack<>();

            // scc 개수 만큼 nums 업데이트
            for (int n : scc) {
                nums[n] = scc.size();
            }

            if (scc.size() > 0) {
                SCC pouch = reverseBFS(scc);
                if (pouch.n <= K) {
                    pouches.add(pouch);
                }
            }

        } // end if
        return result;
    }


    static int[] nums;
    static int[] follows;
    static List<Integer>[] reverse;
    static int[] dfsn;
    static boolean[] finished;
    static boolean[] visited;
    static int sn = 1;
    static List<SCC> pouches;
    static int K;


    static Stack<Integer> S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        follows = new int[N + 1];
        dfsn = new int[N + 1];
        finished = new boolean[N + 1];
        visited = new boolean[N + 1];
        reverse = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            reverse[i] = new ArrayList<>();
        }
        pouches = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int next = Integer.parseInt(st.nextToken());
            follows[i] = next;
            reverse[next].add(i); // 역방향
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                S = new Stack<>();
                getMember(i);
            }
        }
        boolean[][] dp = new boolean[pouches.size() + 1][K + 1];

        dp[0][0] = true;
        for (int i = 1; i <= pouches.size(); i++) { // 선택한 scc
            SCC pouch = pouches.get(i - 1);
            for (int j = 0; j <= K; j++) {
                if (dp[i - 1][j] == true) {
                    dp[i][j] = dp[i - 1][j];
                }

                for (int k = pouch.n; k <= pouch.n + pouch.v; k++) {
                    if (j >= k) {
                        if (dp[i - 1][j - k]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = K; i >= 0; i--) {
            if (dp[pouches.size()][i]) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
