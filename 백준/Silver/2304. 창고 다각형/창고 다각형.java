import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Pole {
        int n;
        int h;

        public Pole(int n, int h) {
            this.n = n;
            this.h = h;
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pole[] poles = new Pole[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            poles[i] = new Pole(l, h);
        }
        Arrays.sort(poles, ((o1, o2) -> o1.n - o2.n));

        Stack<Pole> left = new Stack<>();
        Stack<Pole> right = new Stack<>();

        int curH = 0;
        for (int i = 0; i < N; i++) {
            if (curH < poles[i].h) {
                left.add(poles[i]);
                curH = poles[i].h;
            }
        }


        curH = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (curH < poles[i].h) {
                right.add(poles[i]);
                curH = poles[i].h;
            }
        }


        Pole leftMax = left.pop();
        int answer = 0;
        int curHeight = leftMax.h;
        int curN = leftMax.n;

        while (!left.isEmpty()) {
            Pole curPole = left.pop();
            curHeight = curPole.h;
            int nextN = curPole.n;
            answer += (curN - nextN) * curHeight;
            curN = nextN;
        }

        Pole rightMax = right.pop();
        curHeight = rightMax.h;
        curN = rightMax.n;


        while (!right.isEmpty()) {
            Pole curPole = right.pop();
            curHeight = curPole.h;
            int nextN = curPole.n;
            answer += (nextN - curN) * curHeight;
            curN = nextN;
        }
        answer += (rightMax.n - leftMax.n + 1) * leftMax.h;
        System.out.println(answer);
    }
}
