import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> Q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    int X = Integer.parseInt(st.nextToken());
                    Q.addFirst(X);
                    break;
                case 2:
                    X = Integer.parseInt(st.nextToken());
                    Q.addLast(X);
                    break;
                case 3:
                    if (Q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(Q.pollFirst()).append("\n");
                    }
                    break;
                case 4:
                    if (Q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(Q.pollLast()).append("\n");
                    }
                    break;
                case 5:
                    sb.append(Q.size()).append("\n");

                    break;
                case 6:
                    if (Q.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }

                    break;
                case 7:
                    if (Q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(Q.peekFirst()).append("\n");
                    }
                    break;
                case 8:
                    if (Q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(Q.peekLast()).append("\n");
                    }
                    break;

            }

        } //end while
        System.out.println(sb);


    }
}
