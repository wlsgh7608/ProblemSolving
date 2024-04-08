import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int storeNum = Integer.parseInt(br.readLine());
        int[][] stores = new int[storeNum][2];
        for (int i = 0; i < storeNum; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i][0] = Integer.parseInt(st.nextToken());
            stores[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int loc = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int[] store : stores) {
            answer += getDistance(d, loc, store);
        }
        System.out.println(answer);


    }

    private static int getDistance(int d, int loc, int[] store) {
        int storeD = store[0];
        int storeLoc = store[1];

        if (storeD == d) {
            return Math.abs(storeLoc - loc);
        } else {
            if (storeD == 1) {
                if (d == 2) {
                    return Math.min(storeLoc + loc + N, 2 * M - storeLoc - loc + N);
                } else if (d == 3) {
                    return storeLoc + loc;
                } else if (d == 4) {
                    return M - storeLoc + loc;
                }
            }
            if (storeD == 2) {
                if (d == 1) {
                    return Math.min(storeLoc + loc + N, 2 * M - storeLoc - loc + N);
                } else if (d == 3) {
                    return storeLoc + N - loc;
                } else if (d == 4) {
                    return M - storeLoc + N - loc;
                }
            }
            if (storeD == 3) {
                if (d == 1) {
                    return storeLoc + loc;
                } else if (d == 2) {
                    return N - storeLoc + loc;
                } else if (d == 4) {
                    return Math.min(storeLoc + loc + M, 2 * N - storeLoc - loc + M);
                }
            }
            if (storeD == 4) {
                if (d == 1) {
                    return M - loc + storeLoc;
                } else if (d == 2) {
                    return N - storeLoc + M - loc;
                } else if (d == 3) {
                    return Math.min(storeLoc + loc + M, 2 * N - storeLoc - loc + M);
                }
            }
        }
        return -1;

    }
}
