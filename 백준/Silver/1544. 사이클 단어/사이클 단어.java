import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static boolean isExist(String str, HashSet<String> hs) {

        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i) + str.substring(0, i);
            if (hs.contains(temp)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!isExist(str, hs)) {
                hs.add(str);
            }
        }
        System.out.println(hs.size());
    }
}
