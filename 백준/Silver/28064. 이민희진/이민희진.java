import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int maxK = Integer.min(arr[i].length(), arr[j].length());
                for (int k = 1; k <= maxK; k++) {
                    if (arr[i].endsWith(arr[j].substring(0, k)) ||
                            arr[j].endsWith(arr[i].substring(0, k))) {
                        ans++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
