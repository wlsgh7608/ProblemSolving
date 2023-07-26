import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[] parent;
    static boolean[] isUse;

    static int getParent(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = getParent(parent[v]);
    }


    static void union(int a, int b) {
        if (!isUse[a]) {
            parent[a] = b;
            isUse[a] = true;
        } else if (!isUse[b]) {
            parent[b] = a;
            isUse[b] = true;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        parent = new int[L + 1];
        isUse = new boolean[L + 1];

        for (int i = 1; i <= L; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean canMove = true;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a = getParent(a);
            b = getParent(b);

            if (a == b) {
                if (isUse[a]) {
                    canMove = false;
                } else {
                    union(a, b);
                }
            } else if (a != b) {
                if (isUse[a] && isUse[b]) {
                    canMove = false;
                } else {
                    union(a, b);
                }
            }


            if (canMove) {
                sb.append("LADICA").append("\n");
            } else {
                sb.append("SMECE").append("\n");
            }

        }
        System.out.println(sb);


    }
}

