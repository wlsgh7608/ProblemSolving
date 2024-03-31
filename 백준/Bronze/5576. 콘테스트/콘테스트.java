import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] aArr = new int[10];
        int[] bArr = new int[10];
        for (int i = 0; i < 10; i++) {
            aArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            bArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(aArr);
        Arrays.sort(bArr);

        int aTot = 0;
        int bTot = 0;
        for(int i = 7;i<10;i++){
            aTot += aArr[i];
            bTot += bArr[i];
        }
        System.out.println(aTot + " " + bTot);
    }
}
