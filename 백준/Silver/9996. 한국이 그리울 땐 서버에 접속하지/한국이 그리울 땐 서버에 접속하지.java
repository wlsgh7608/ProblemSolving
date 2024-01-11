import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String prefix = st.nextToken();
        String suffix = st.nextToken();
        int minLen = prefix.length() + suffix.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {

            String fileName = br.readLine();
            if (fileName.startsWith(prefix) && fileName.endsWith(suffix) && fileName.length() >= minLen) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
