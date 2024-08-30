import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());



        int[] arr = new int[1301];
        int cur = 10000;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(c==1){
                if(arr[price/10]>0){
                    cur = price;
                }
                arr[price/10] -= cnt;
            }else{
                if(arr[price/10]<0){
                    cur = price;
                }
                arr[price/10] += cnt;
            }
        }
        System.out.println(cur);




    }
}
