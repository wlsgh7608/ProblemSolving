import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String buffer = "";
            int M = str.length();

            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if ('0' <= c && c <= '9') {
                    buffer = buffer + c;
                } else {
                    if (!buffer.equals("")) {
                        BigInteger n = new BigInteger(buffer);
                        list.add(n);
                        buffer = "";
                    }
                }
            }
            if (!buffer.equals("")) {
                BigInteger n = new BigInteger(buffer);
                list.add(n);
            }
        }// end for
        Collections.sort(list);
        for (BigInteger n : list) {
            sb.append(n).append("\n");
        }
        System.out.println(sb);

    }
}
