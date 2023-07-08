import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] candy = new int[N];
            for(int i = 0  ;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                candy[i] = r*c;
            }

            Arrays.sort(candy);
            reverse(candy);
            int result = 0;
            for(int i =0 ; i<N;i++){
                if(J<=0){
                    break;
                }
                J-= candy[i];
                result++;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }


    static void reverse(int[] arr){
        int x = 0;
        int y = arr.length-1;
        while(x<y){
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
            x++;
            y--;
        }

    }
}
