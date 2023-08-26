import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(br.readLine());
                hs.add(n);
            }
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                int n = Integer.parseInt(br.readLine());
                if (hs.contains(n)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
