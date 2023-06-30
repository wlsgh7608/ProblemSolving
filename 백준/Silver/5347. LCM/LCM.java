import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long getGCD(long a,long b){

        while (b != 0) {
            long tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for(int i= 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            sb.append(a * b / getGCD(a, b)).append("\n");

        }
        System.out.println(sb);
    }
}
