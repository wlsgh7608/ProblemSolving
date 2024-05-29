import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int JOI = 0;
        int IOI = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'J' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
                JOI++;
            } else if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
                IOI++;
            }
        }
        System.out.println(JOI);
        System.out.println(IOI);

    }
}
