import java.util.*;

class Solution {
    static long calc(long a, long b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:// 연산자가 *
                return a * b;
        }
    }

    static long solve() {
        List<Long> newNums = new ArrayList<>(nums);
        List<Character> newOps = new ArrayList<>(ops);

        // 연산자 우선순위가 높은 것부터 반복문 돌아서 실행
        for (char op : opOrder) {
            for (int i = 0; i < newOps.size(); i++) {
                if (newOps.get(i) == op) {
                    long n1 = newNums.get(i);
                    long n2 = newNums.get(i + 1);
                    long result = calc(n1, n2, op);

                    newNums.remove(i + 1);
                    newNums.remove(i);
                    newNums.add(i, result);

                    newOps.remove(i);
                    i--;
                }
            }
        }
        long result = Math.abs(newNums.get(0));
        return result;
    }

    /* 연산 우선순위 순열 */
    static void perm(int depth) {
        if (depth == 3) {
            long result = solve();
            maxVal = Math.max(maxVal, result);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                opOrder[depth] = opArr[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }


    static char[] opOrder = new char[3];
    static boolean[] visited = new boolean[3];
    static char[] opArr = {'+', '-', '*'};
    static long maxVal = 0;

    static List<Long> nums;
    static List<Character> ops;

    public long solution(String expression) {
        String del = "+-*";
        StringTokenizer st = new StringTokenizer(expression, del, true);

        nums = new ArrayList<>();
        ops = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (next.length() == 1 && del.contains(next)) {
                ops.add(next.charAt(0));
            } else {
                long n = Long.parseLong(next);
                nums.add(n);
            }
        }
        perm(0);

        return maxVal;
    }
}