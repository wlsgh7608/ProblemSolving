class Solution {
 public int[] solution(int[] sequence, int k) {
        // sequence 오름차순
        int left = 0;
        int right = 0;
        int N = sequence.length;

        int sum = 0;
        int[] answer = new int[2];
        answer[1] = N - 1;

        while (left <= right ) {
   
            int len = right - left;
            int answerLen = answer[1] - answer[0] + 1;
            if (sum == k && len < answerLen) {
                answer[0] = left;
                answer[1] = right - 1;
            }


            if (sum > k) {
                sum -= sequence[left++];
            } else if (right < N) {
                sum += sequence[right++];
            }else if(right==N){
                break;
            }

        }


        return answer;
    }

}