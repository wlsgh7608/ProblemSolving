import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};


        int totDay = 0;
        for (int i = 0; i < M; i++) {
            totDay += month[i];
        }
        totDay += D - 1;
        int remain = totDay % 7;
        System.out.println(day[remain]);

    }
}
