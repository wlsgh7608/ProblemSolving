import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = new char[N];


        int p = 0;
        boolean isTrue = true;

        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            int idx = (N + p - (s%N)) % N;
            if (arr[idx] != 0) {
                if (arr[idx] != c) {
                    isTrue = false;
                    break;
                }
            } else if (hs.contains(c)) {
                isTrue = false;
                break;
            }

            arr[idx] = c;
            hs.add(c);
            p = idx;
        }

        if (isTrue) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                char c = (arr[(p + i) % N]);
                if (c == 0) {
                    sb.append("?");
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb);

        } else {
            System.out.println("!");
        }

    }


}
