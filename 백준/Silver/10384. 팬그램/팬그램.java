import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            int[] arr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    arr[c - 'a']++;
                } else if (c >= 'A' && c <= 'Z') {
                    arr[c - 'A']++;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                min = Math.min(min, arr[j]);
            }
            sb.append("Case ").append(i).append(": ");
            if (min == 0) {
                sb.append("Not a pangram");

            } else if (min == 1) {
                sb.append("Pangram!");

            } else if (min == 2) {
                sb.append("Double pangram!!");
            } else {
                sb.append("Triple pangram!!!");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
