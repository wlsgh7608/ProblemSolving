import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());


        int costY = 0;
        int costM = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            costY += (arr[i] / 30 + 1) * 10;
            costM += (arr[i] / 60 + 1) * 15;
        }

        if (costY < costM) {
            System.out.println("Y " + costY);
        } else if (costY > costM) {
            System.out.println("M " + costM);
        } else {
            System.out.println("Y M " + costY);
        }

    }
}
