import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = new int[1001];
        int maxCnt = 0;
        int freqNum = 0;
        int tot = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num]++;
            tot += num;
            if (cnt[num] > maxCnt) {
                maxCnt = cnt[num];
                freqNum = num;
            }
        }
        System.out.println(tot / 10);
        System.out.println(freqNum);
    }
}
