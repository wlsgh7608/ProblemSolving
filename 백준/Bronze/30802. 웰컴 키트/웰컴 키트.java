import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] size = new int[6];

        for (int i = 0; i < size.length; i++)
            size[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());  
        int P = Integer.parseInt(st.nextToken());  

        int tCount = 0; // 티셔츠 주문 묶음 수
        for (int j = 0; j < size.length; j++) {
            tCount += size[j] / T;
            if (size[j] % T != 0)
                tCount++;
        }
        sb.append(tCount).append("\n");
        sb.append(N / P).append(" ").append(N % P);

        System.out.println(sb);
    }
}
