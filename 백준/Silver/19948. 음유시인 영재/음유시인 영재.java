import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String title = br.readLine();
        int spaceBarCnt = Integer.parseInt(br.readLine());
        int[] alphabetCnt = new int[26];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 26; i++) {
            alphabetCnt[i] = Integer.parseInt(st.nextToken());
        }


        char prev = ' ';

        boolean isPossible = true;

        for (int i = 0; i < title.length(); i++) {
            char cur = title.charAt(i);
            if (cur != prev) {
                if (cur == ' ') {
                    if (--spaceBarCnt < 0) {
                        isPossible = false;
                        break;
                    }

                } else {
                    int idx = 0;
                    if ('a' <= cur && cur <= 'z') {
                        idx = cur - 'a';
                    } else {
                        idx = cur - 'A';
                    }
                    if (--alphabetCnt[idx] < 0) {
                        isPossible = false;
                        break;

                    }
                }
                if(prev ==' ' && cur !='-'){
                    int idx = 0;
                    if ('a' <= cur && cur <= 'z') {
                        idx = cur - 'a';
                    } else {
                        idx = cur - 'A';
                    }
                    if (--alphabetCnt[idx] < 0) {
                        isPossible = false;
                        break;

                    }
                }
                prev = cur;
            }
        }

        if (isPossible) {
            st = new StringTokenizer(title);
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken().charAt(0));
            }
            System.out.println(sb.toString().toUpperCase());

        } else {
            System.out.println(-1);
        }
    }


}
