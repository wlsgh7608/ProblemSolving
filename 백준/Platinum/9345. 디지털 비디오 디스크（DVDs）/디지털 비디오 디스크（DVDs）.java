import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int calc(int a, int b, boolean isMin) {
        if (isMin) {
            return Math.min(a, b);
        } else {
            return Math.max(a, b);
        }
    }

    static int init(int idx, int s, int e, boolean isMin) {
        if (s == e) {
            if (isMin) {
                return treeMin[idx] = s;
            } else {
                return treeMax[idx] = s;
            }
        }
        int m = (s + e) / 2;
        int left = init(idx * 2, s, m, isMin);
        int right = init(idx * 2 + 1, m + 1, e, isMin);
        if (isMin) {
            return treeMin[idx] = calc(left, right, true);
        } else {
            return treeMax[idx] = calc(left, right, false);
        }
    }

    static int query(int qL, int qR, int idx, int treeL, int treeR, boolean isMin) {
        if (qR < treeL || treeR < qL) {
            if (isMin) {
                return 100_000;
            } else {
                return 0;
            }
        }
        if (qL <= treeL && treeR <= qR) {
            if (isMin) {
                return treeMin[idx];
            } else {
                return treeMax[idx];
            }
        }

        int m = (treeL + treeR) / 2;
        int left = query(qL, qR, idx * 2, treeL, m, isMin);
        int right = query(qL, qR, idx * 2+1, m + 1, treeR, isMin);
        return calc(left, right, isMin);
    }

    static int update(int uI, int uV, int idx, int treeL, int treeR, boolean isMin) {
        if (uI < treeL || treeR < uI) {
            if (isMin) {
                return treeMin[idx];
            } else {
                return treeMax[idx];
            }
        }
        if (treeL == treeR) {
            if (isMin) {
                return treeMin[idx] = uV;
            } else {
                return treeMax[idx] = uV;
            }
        }

        int m = (treeL + treeR) / 2;
        int left = update(uI, uV, idx * 2, treeL, m, isMin);
        int right = update(uI, uV, idx * 2 + 1, m + 1, treeR, isMin);

        if (isMin) {
            return treeMin[idx] = calc(left, right, isMin);
        } else {
            return treeMax[idx] = calc(left, right, isMin);
        }
    }

    static int[] treeMin;
    static int[] treeMax;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] loc = new int[N];
            treeMin = new int[4 * N];
            treeMax = new int[4 * N];
            for (int i = 0; i < N; i++) {
                loc[i] = i;
            }
            init(1, 0, N - 1, true);
            init(1, 0, N - 1, false);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                // query
                if (a == 1) {
                    int minV = query(b, c, 1, 0, N - 1, true);
                    int maxV = query(b, c, 1, 0, N - 1, false);
                    if (minV == b && maxV == c) {
                        sb.append("YES").append("\n");
                    } else {
                        sb.append("NO").append("\n");
                    }
                } else {
                    //update
                    int tmp = loc[b];
                    loc[b] = loc[c];
                    loc[c] = tmp;

                    update(b, loc[b], 1, 0, N - 1, true);
                    update(b, loc[b], 1, 0, N - 1, false);
                    update(c, loc[c], 1, 0, N - 1, true);
                    update(c, loc[c], 1, 0, N - 1, false);
                }


            }
        } // end for
        System.out.println(sb);
    }
}
