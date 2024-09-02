import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] stick = new int[3];
        int i = 0;
        while(st.hasMoreTokens()) {
            stick[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(stick);

        if(stick[2] >= stick[0] + stick[1]) {
            while(stick[2] >= stick[0] + stick[1]) {
                stick[2]--;
            }
            System.out.println(stick[0] + stick[1] + stick[2]);


        } else {
            System.out.println(stick[0] + stick[1] + stick[2]);
        }


    }
}