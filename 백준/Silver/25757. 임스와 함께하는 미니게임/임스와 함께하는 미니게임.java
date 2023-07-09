import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hs.add(br.readLine());
        }

        int ans = 0;
        switch (c) {
            case 'Y':
                ans = hs.size();
                break;
            case 'F':
                ans = hs.size() / 2;
                break;
            case 'O':
                ans = hs.size() / 3;
                break;
        }
        System.out.println(ans);

    }
}
