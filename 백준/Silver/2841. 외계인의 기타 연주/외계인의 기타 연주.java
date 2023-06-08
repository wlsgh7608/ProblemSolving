import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer>[] stacks = new Stack[7];

        for (int i = 1; i <= 6; i++) {
            stacks[i] = new Stack<Integer>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());


            while (!stacks[n].isEmpty() && stacks[n].peek() > p) {
                stacks[n].pop();
                cnt++;
            }

            if (stacks[n].isEmpty() || stacks[n].peek() < p) {
                stacks[n].push(p);
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
