import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void swap(int aIdx, int bIdx, int[] arr) {
        int tmp = arr[aIdx];
        arr[aIdx] = arr[bIdx];
        arr[bIdx] = tmp;
    }

    static boolean whileCondition(int[] arr) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != i + 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        while (whileCondition(arr)) {
            for (int i = 1; i < 5; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(i - 1, i, arr);
                    for (int j = 0; j < 5; j++) {
                        sb.append(arr[j]).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);


    }
}
