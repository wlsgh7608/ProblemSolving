import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int profit = e - c - r;
            if (profit > 0) {
                sb.append("advertise").append("\n");

            } else if (profit == 0) {
                sb.append("does not matter").append("\n");
            } else {
                sb.append("do not advertise").append("\n");
            }

        }
        System.out.println(sb);


    }
}
