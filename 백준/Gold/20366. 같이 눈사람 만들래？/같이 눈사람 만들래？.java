import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);

        int minV = Integer.MAX_VALUE;
        loop:
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int snowMan1 = arr[i] + arr[j];
                int lo = 0;
                int hi = N - 1;


                while (lo < hi) {
                    // 선택한 눈덩이가 달라야 함
                    if (lo == i || lo == j) {
                        lo++;
                        continue;
                    } else if (hi == i || hi == j) {
                        hi--;
                        continue;
                    }
                    int snowMan2 = arr[lo] + arr[hi];

                    if (snowMan2 > snowMan1) {
                        minV = Math.min(minV, snowMan2 - snowMan1);
                        hi--;
                    } else if (snowMan2 < snowMan1) {
                        minV = Math.min(minV, snowMan1 - snowMan2);
                        lo++;
                    } else {
                        minV = 0;
                        break loop;
                    }

                }
            }
        }
        System.out.println(minV);
    }
}
