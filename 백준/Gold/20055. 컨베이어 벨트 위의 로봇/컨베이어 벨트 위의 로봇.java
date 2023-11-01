import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static void rotate() {
        int tmp = arr[2 * N - 1];

        for (int i = 2 * N - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmp;


        for (int i = N - 1; i > 0; i--) {
            isRobot[i] = isRobot[i - 1];
        }
        isRobot[0] = false;
        isRobot[N - 1] = false;
    }

    static void move() {

        for (int i = N - 1; i > 0; i--) {
            if (isRobot[i - 1] && !isRobot[i] && arr[i] > 0) {
                if (--arr[i] == 0) {
                    zeroCnt++;
                }
                isRobot[i] = isRobot[i - 1];
                isRobot[i - 1] = false;
            }
        }
        isRobot[N - 1] = false;

    }

    static void up() {
        if (arr[0] > 0) {
            if (--arr[0] == 0) {
                zeroCnt++;
            }
            isRobot[0] = true;
        }
    }

    static int simulate() {
        int step = 1;
        while (true) {
            rotate();
            move();
            up();
            if (zeroCnt >= K) {
                break;
            }
            step++;

        }
        return step;


    }

    static int[] arr;
    static boolean[] isRobot;
    static int N, K;
    static int zeroCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[2 * N];
        isRobot = new boolean[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = simulate();
        System.out.println(result);

    }
}
