import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("int a;").append("\n");
        String prev = "a";
        String cur = "ptr";
        String star = "*";
        for (int i = 1; i <= N; i++) {
            sb.append("int " + star + cur + " = &" + prev + ";").append("\n");
            prev = cur;
            star += "*";
            cur = "ptr" + (i + 1);
        }
        System.out.println(sb);

    }
}
