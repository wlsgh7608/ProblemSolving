import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            String[] str = br.readLine().split(" ");
            int sum = 0;
            for (String s : str) {
                sum += Integer.parseInt(s);
            }
            sb.append("Case ").append(i).append(": ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
