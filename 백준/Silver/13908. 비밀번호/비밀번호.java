import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // M개의 비밀번호 ->비밀번호로 만들 수 있는 숫자
        int[] usePw = new int[M];
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                usePw[i] = Integer.parseInt(st.nextToken());
            }

        }

        int answer = 0;
        boolean[] isUsed = new boolean[10];
        nextPw:
        for (int i = 0; i < (int) Math.pow(10, N); i++) {
            Arrays.fill(isUsed, false);
            int temp = i;

            for (int j = 0; j < N; j++) {
                isUsed[temp % 10] = true;
                temp /= 10;
            }

            for (int j = 0; j < M; j++) {
                if (!isUsed[usePw[j]]) {
                    continue nextPw;
                }
            }
            answer++;
        }

        System.out.println(answer);

    }
}
