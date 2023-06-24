import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[21];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    cnt[j] = 1;
                }
            } else if (a.equals("empty")) {
                for (int j = 1; j <= 20; j++) {
                    cnt[j] = 0;
                }
            } else {
                int b = Integer.parseInt(st.nextToken());
                if (a.equals("add")) {
                    cnt[b] = 1;
                } else if (a.equals("remove")) {
                    cnt[b] = 0;
                } else if (a.equals("toggle")) {
                    if (cnt[b] == 1) {
                        cnt[b] = 0;
                    } else {
                        cnt[b] = 1;
                    }
                } else {
                    if (cnt[b] == 0) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(1).append("\n");
                    }
                }
            }

        } // end for
        System.out.println(sb);

    }
}
