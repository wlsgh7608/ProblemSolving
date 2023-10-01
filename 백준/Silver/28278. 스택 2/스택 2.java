import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1:
                    int b = Integer.parseInt(st.nextToken());
                    S.add(b);
                    break;
                case 2:
                    if (S.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(S.pop());
                    }
                    sb.append("\n");
                    break;
                case 3:
                    sb.append(S.size()).append("\n");
                    break;
                case 4:
                    if (S.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case 5:
                    if (S.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(S.peek());
                    }
                    sb.append("\n");
                    break;

            }

        }
        //end for
        System.out.println(sb);
    }
}
