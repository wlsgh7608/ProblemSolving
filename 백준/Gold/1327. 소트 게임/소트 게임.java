import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String ans;

    static class Practice{
        String str;
        int cnt;

        public Practice(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    static String reverse(String str,int idx, int K){
        String newStr = str.substring(idx, idx + K);
        String result = "";
        for(int i = newStr.length()-1;i>=0;i--){
            result += newStr.charAt(i);
        }
        return result;
    }

    static String calc(String str,int i,int K) {
        String sub1 = str.substring(0, i);
        String sub2 = reverse(str, i, K);
        String sub3 = str.substring(i + K);
        return sub1 + sub2 + sub3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sortArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortArr[i] = arr[i];
        }
        Arrays.sort(sortArr);
        ans = "";
        for (int n : sortArr) {
            ans += n;
        }
        String start = "";
        for(int n: arr){
            start += n;
        }

        Queue<Practice> Q = new ArrayDeque<>();

        Q.add(new Practice(start, 0));
        HashSet<String> hs = new HashSet<>();
        hs.add(start);
        int result = -1;
        while(!Q.isEmpty()){
            Practice cur = Q.poll();
            String str = cur.str;
            int cnt = cur.cnt;
            if(str.equals(ans)){
                result=cnt;
                break;
            }
            for(int i = 0; i<=N-K;i++){
                String next = calc(str, i, K);
                if(!hs.contains(next)){
                    hs.add(next);
                    Q.add(new Practice(next, cnt + 1));
                }
            }

        }
        System.out.println(result);


    }
}
