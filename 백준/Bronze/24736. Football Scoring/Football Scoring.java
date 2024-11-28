import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aScore = 0;
        int bScore = 0;
        int[] score = new int[]{6, 3, 2, 1, 2};

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            aScore += score[i] * Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            bScore += score[i] * Integer.parseInt(st.nextToken());
        }
        System.out.println(aScore);
        System.out.println(bScore);


    }
}
