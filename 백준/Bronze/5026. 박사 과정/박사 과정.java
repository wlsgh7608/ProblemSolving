import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<T;i++){
            String str = br.readLine();
            if (str.equals("P=NP")) {
                sb.append("skipped").append("\n");
                continue;
            }

            StringTokenizer st = new StringTokenizer(str, "+");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = a + b;
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
