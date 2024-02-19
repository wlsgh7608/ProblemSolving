import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " -");

        int cnt = 0;


        String[] frontList = new String[] {"c", "j", "n", "m", "t", "s", "l", "d", "qu"};
        String[] endList = new String[]{"a", "e", "i", "o", "u", "h"};

        HashSet<String> frontSet = new HashSet<>();
        for(String front: frontList){
            frontSet.add(front);
        }


        while (st.hasMoreTokens()) {
            String words = st.nextToken();

            int idx = words.indexOf("'");
            if (idx != -1) {
                String front = words.substring(0, idx);
                String end = words.substring(idx + 1);


                if (frontSet.contains(front)) {
                    for (String vowel : endList) {
                        if (end.startsWith(vowel)) {
                            cnt++;
                            break;
                        }
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);


    }
}
