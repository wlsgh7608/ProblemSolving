import java.util.*;
class Solution {
    public static final int MAX_VALUE = 10;
    public static final int MAX_DEPTH = 9;

    int[] minCnt;
    HashSet<Integer>[] hs = new HashSet[MAX_DEPTH];


    void dfs(int depth, int N) {

        if (depth > 8) {
            return;
        }
        hs[depth] = new HashSet<>();

        int tmp = 0;
        for (int i = 0; i < depth; i++) {
            tmp = tmp * 10 + N;
        }
        hs[depth].add(tmp);


        for (int i = 1; i <= depth; i++) {
            for (int j = 1; i + j <= depth; j++) {

                for (int a : hs[i]) {
                    for (int b : hs[j]) {
                        hs[depth].add(a + b);
                        hs[depth].add(a - b);
                        hs[depth].add(a * b);
                        if (b != 0) {
                            hs[depth].add(a / b);
                            hs[depth].add(a % b);

                        }

                    }
                }
            }
        }
        dfs(depth + 1, N);


    }

    public int solution(int N, int number) {
        minCnt = new int[32_001];

        // A ? B
        // A+B
        // A*B
        // A-B
        // A/B
        // A%B
        dfs(1, N);

        for (int i = 1; i <= 8; i++) {
            if (hs[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }
}