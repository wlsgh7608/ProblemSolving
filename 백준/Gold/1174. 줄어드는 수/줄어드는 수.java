import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    static void perm(long n, long idx) {
        if (!hs.contains(n)) {
            hs.add(n);
        }
        if (idx == 11) {
            return;
        }
        for (long i = idx; i < 10; i++) {
            perm(n * 10 + arr[(int) i], i + 1);
            perm(n, i + 1);
        }
    }

    static HashSet<Long> hs;
    static long[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hs = new HashSet<>();
        perm(0, 0);
        List<Long> result = new ArrayList(hs);
        Collections.sort(result);
        if (result.size() < n) {
            System.out.println(-1);
        } else {
            System.out.println(result.get(n - 1));
        }
    }
}
