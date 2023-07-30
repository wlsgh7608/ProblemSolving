import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int getCenter(int v) {
        if (center[v] == v) {
            return v;
        }

        int tmp = getCenter(center[v]);
        toCenter[v] += toCenter[center[v]];
        return center[v] = tmp;
    }

    static void union(int a, int b) {

        center[a] = b;
        int dist = Math.abs(a - b);
        toCenter[a] = dist % 1000;
    }

    static int[] center;
    static int[] toCenter;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            center = new int[N + 1];
            toCenter = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                center[i] = i;
            }
            while (true) {
                String input = br.readLine();

                char c = input.charAt(0);
                if (c == 'O') {
                    break;
                }

                StringTokenizer st = new StringTokenizer(input);
                st.nextToken();
                if (c == 'I') {
                    // 센터 연결
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    union(a, b);

                } else {
                    //기업 I, 센터 I의 거리 출력
                    int i = Integer.parseInt(st.nextToken());
                    getCenter(i);
                    sb.append(toCenter[i]).append("\n");
                }
            }
        }//end for
        System.out.println(sb);
    }

}
