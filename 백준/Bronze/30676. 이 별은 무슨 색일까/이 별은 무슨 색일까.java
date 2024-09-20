import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String getColor(int N) {
        if (N < 425) {
            return "Violet";
        } else if (N < 450) {
            return "Indigo";

        } else if (N < 495) {
            return "Blue";
        } else if (N < 570) {
            return "Green";
        } else if (N < 590) {
            return "Yellow";

        } else if (N < 620) {
            return "Orange";
        } else if (N <= 780) {
            return "Red";
        }
        return "Nothing";

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(getColor(N));


    }
}
