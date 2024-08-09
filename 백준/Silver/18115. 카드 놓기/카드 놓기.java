import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> DQ = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            DQ.add(i);
        }

        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int idx = DQ.pollFirst();
                result[idx] = N - i;

            } else if (cmd == 2) {
                int first = DQ.pollFirst();
                int second = DQ.pollFirst();
                DQ.addFirst(first);
                result[second] = N - i;
            } else {
                int idx = DQ.pollLast();
                result[idx] = N - i;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);


    }
}
