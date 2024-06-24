import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrA = new int[2];
        int[] arrB = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        arrA[0] = Integer.parseInt(st.nextToken());
        arrA[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arrB[0] = Integer.parseInt(st.nextToken());
        arrB[1] = Integer.parseInt(st.nextToken());

        while (arrA[1] > 0 && arrB[1] > 0) {
            arrA[1] -= arrB[0];
            arrB[1] -= arrA[0];
        }

        if (arrA[1] <= 0 && arrB[1] <= 0) {
            System.out.println("DRAW");
        } else if (arrB[1] <= 0) {
            System.out.println("PLAYER A");
        } else {
            System.out.println("PLAYER B");
        }

    }
}
