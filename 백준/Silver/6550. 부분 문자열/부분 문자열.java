import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str ==null || str.equals("")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            String aStr = st.nextToken();
            String bStr = st.nextToken();

            int A = aStr.length();
            int B = bStr.length();

            int p = 0;

            boolean isTrue = false;
            for (int i = 0; i < B; i++) {
                char c = bStr.charAt(i);
                if (c == aStr.charAt(p)) {
                    if (++p == A) {
                        isTrue = true;
                        break;
                    }
                }
            }
            if (isTrue) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }
        System.out.println(sb);


    }
}
