import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N - 1; i++) {
            int n = Integer.parseInt(br.readLine());
            PQ.add(n);
        }

        int cnt = 0;
        while (!PQ.isEmpty() && a <= PQ.peek()) {
            PQ.add(PQ.poll() - 1);
            cnt++;
            a++;

        }
        System.out.println(cnt);


    }
}
