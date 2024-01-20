import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];

        int tot = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            tot += arr[i];
        }

        Arrays.sort(arr);
        System.out.println(tot / 5);
        System.out.println(arr[2]);


    }
}
