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
        boolean isAsc = true;
        for (int i = 1; i < N; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0) {
                {
                    isAsc = false;
                }
            }
        }
        boolean isDesc = true;
        for (int i = 1; i < N; i++) {
            if (arr[i].compareTo(arr[i - 1]) > 0) {
                {
                    isDesc = false;
                }
            }
        }
        if (isAsc) {
            System.out.println("INCREASING");
        } else if (isDesc) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}
