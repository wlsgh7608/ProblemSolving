import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Number implements Comparable<Number> {
        int n;
        int cnt;
        int idx;

        public Number(int n, int cnt, int idx) {
            this.n = n;
            this.cnt = cnt;
            this.idx = idx;
        }

        public int compareTo(Number o) {
            if (o.cnt == this.cnt) {
                return this.idx - o.idx;
            }
            return o.cnt - this.cnt;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> cntHm = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (!hm.containsKey(n)) {
                hm.put(n, i);
            }
            cntHm.put(n, cntHm.getOrDefault(n, 0) + 1);
        }

        List<Number> list = new ArrayList<>();

        for (Integer key : cntHm.keySet()) {
            int cnt = cntHm.get(key);
            int idx = hm.get(key);
            list.add(new Number(key, cnt, idx));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Number number : list) {
            for (int i = 0; i < number.cnt; i++) {
                sb.append(number.n + " ");
            }
        }
        System.out.println(sb);


    }
}
