import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] clock = new int[4];
    static HashSet<Integer> hs = new HashSet<>();
    static void dfs(int depth) {
        if (depth == 4) {

            int num = getMin(clock);
            hs.add(num);
            return;

        }


        for (int i = 1; i <= 9; i++) {
            clock[depth] = i;
            dfs(depth + 1);
        }


    }

    static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            int num = 0;
            for(int j=0;j<4;j++){
                num = num*10+arr[(i+j)%4];
            }
            min = Math.min(min,num);
        }
        return min;

    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dfs(0);
        List<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);

        int[] arr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = getMin(arr);

        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num) {
                idx = i;
                break;
            }
        }
        System.out.println(idx + 1);
    }
}
