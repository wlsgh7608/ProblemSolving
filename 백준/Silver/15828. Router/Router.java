import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int buffer = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new ArrayDeque<>();
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == -1) {
                break;
            }


            if (input == 0) {
                Q.poll();
            } else if (Q.size() < buffer) {
                Q.add(input);
            }
        }

        if (Q.isEmpty()) {
            System.out.println("empty");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!Q.isEmpty()) {
                sb.append(Q.poll()).append(" ");
            }
            System.out.println(sb);
        }
    }
}
