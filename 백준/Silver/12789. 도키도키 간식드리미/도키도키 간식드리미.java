import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        Queue<Integer> Q = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {
            Q.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> S = new Stack<>();


        int cur = 1;


        while (cur <= N) {
            if (!Q.isEmpty() && Q.peek() == cur) {
                Q.poll();
                cur++;
                continue;
            }

            if (!S.isEmpty() && S.peek() == cur) {
                S.pop();
                cur++;
                continue;
            }

            if (Q.isEmpty()) {
                break;
            }
            S.add(Q.poll());

        }

        if (cur < N) {
            System.out.println("Sad");
        } else {
            System.out.println("Nice");

        }


    }
}
