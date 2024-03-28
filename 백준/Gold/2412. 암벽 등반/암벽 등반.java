import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Hole {

        int x;
        int y;
        int cnt;

        public Hole(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Hole[] holes = new Hole[N];

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            holes[i] = new Hole(x, y, 0);
            hm.put(x + " " + y, i);
        }


        Queue<Hole> Q = new ArrayDeque<>();
        Q.add(new Hole(0, 0, 0));
        int ans = -1;
        while (!Q.isEmpty()) {
            Hole cur = Q.poll();
            int x = cur.x;
            int y = cur.y;
            int cnt = cur.cnt;

            if (y == T) {
                ans = cnt;
                break;
            }
            /* 큐에 넣어야 하는 홀....찾아야 함 a-x, b-x
             * */
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    int nx = x + i;
                    int ny = y + j;
                    String key = nx + " " + ny;
                    if (hm.containsKey(key)) {
                        int idx = hm.get(key);
                        if (dist[idx] > cnt) {
                            dist[idx] = cnt;
                            Q.add(new Hole(nx, ny, cnt + 1));
                        }
                    }

                }
            }


        }
        System.out.println(ans);
    }
}
