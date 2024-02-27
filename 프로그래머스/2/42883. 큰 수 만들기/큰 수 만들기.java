class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int N = number.length();

        int maxIdx = 0;
        int iter = N - k;

        for (int i = 0; i < iter; i++) {
            int max = 0; // 최댓값
            for (int j = maxIdx; j <= i + k; j++) {
                int n = number.charAt(j) - '0';
                if (max < n) {
                    max = n;
                    maxIdx = j + 1;
                }
            }
            sb.append(max);
        }


        return sb.toString();
    }

}