import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int aMoney = N;
        int bMoney = N;
        int aCnt = 0;
        int bCnt = 0;

        int prev = 0;

        int iCnt = 0;
        int dCnt = 0;
        int lastMoney = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (i == 0) {
                prev = cur;
            }
            if (prev < cur) {
                iCnt++;
                dCnt = 0;
            } else if (prev > cur) {
                dCnt++;
                iCnt = 0;
            }

            if (aMoney >= cur) {
                int cnt = aMoney / cur;
                aMoney -= cnt * cur;
                aCnt += cnt;
            }

            if (iCnt >= 3 && bCnt > 0) {
                bMoney += bCnt * cur;
                bCnt = 0;
            } else if (dCnt >= 3 && bMoney >= cur) {
                int cnt = bMoney / cur;
                bCnt += cnt;
                bMoney -= cnt * cur;
            }
            prev = cur;
            lastMoney = cur;
        }
        int aResult = aMoney + aCnt * lastMoney;
        int bResult = bMoney + bCnt * lastMoney;
        if(aResult>bResult){
            System.out.println("BNP");
        }else if(aResult<bResult){
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }
    }
}
