import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static List<Integer> lis = new ArrayList<>();

    private static int finxIdx(int target) {
        int s = 0;
        int e = lis.size() - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            if (lis.get(m) > target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int n : arr) {
            int idx = finxIdx(n);
            if (idx == lis.size()) {
                lis.add(n);
            } else {
                lis.set(idx, n);
            }
        }
        System.out.println(N - lis.size());
    }
}
