import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = 0;
        A += 3 * Integer.parseInt(br.readLine());
        A += 2 * Integer.parseInt(br.readLine());
        A += Integer.parseInt(br.readLine());

        int B = 0;
        B += 3 * Integer.parseInt(br.readLine());
        B += 2 * Integer.parseInt(br.readLine());
        B += Integer.parseInt(br.readLine());

        if (A > B) {
            System.out.println("A");
        } else if (A < B) {
            System.out.println("B");
        } else {
            System.out.println("T");
        }

    }
}
