import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        int[] arr = new int[26];
        while ((str = br.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    arr[str.charAt(i) - 'a']++;
                }
            }
        }

        int max = 0;

        String ans = "";

        for(int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ans = "";
            }
            if (arr[i] == max) {
                ans += (char) (i + 'a');
            }
        }
        System.out.println(ans);
    }
}
