import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int[] arr = new int[C];
        int[] cnt = new int[C + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = 0;

        boolean isTrue = true;
        int[] ans = new int[C];
        for (int i = 0; i < C; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int cur = arr[i];
            if (prev <= cur) {
                if (prev + 1 < cur) {
                    isTrue = false;
                    break;
                } else if (prev + 1 == cur) {
                    cnt[cur] = 0;
                }
            }
            cnt[cur]++;
            ans[i] = cnt[cur];
            prev = cur;
        }

        if(isTrue){
            StringBuilder sb = new StringBuilder();
            for(int n : ans){
                sb.append(n+" ");
            }
            System.out.println(sb);
        }else{
            System.out.println(-1);
        }


    }
}
