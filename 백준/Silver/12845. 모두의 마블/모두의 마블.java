import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> PQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) {
            PQ.add(Integer.parseInt(st.nextToken()));
        }

        int score = 0;

        while (PQ.size() > 1) {
            int first = PQ.poll();
            int second = PQ.poll();
            int sum = first + second;
            PQ.add(first);
            score += sum;
        }
        System.out.println(score);


    }

}
