import java.util.*;
class Solution {
    public int[] solution(int[] answers) {

        int[][] mathGiver = new int[4][];
        mathGiver[1] = new int[]{1, 2, 3, 4, 5};
        mathGiver[2] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        mathGiver[3] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


        int[] answerCnt = new int[4];

        for (int i = 0; i < answers.length; i++) {

            for (int j = 1; j <= 3; j++) {
                int iterSize = mathGiver[j].length;
                if (mathGiver[j][i % iterSize] == answers[i]) {
                    answerCnt[j]++;
                }
            }
        }


        List<Integer> winners = new ArrayList<>();
        int winCnt = -1;
        for (int i = 1; i <= 3; i++) {
            if (answerCnt[i] >= winCnt) {
                if(answerCnt[i]>winCnt){
                winners = new ArrayList<>();
                    
                winCnt = answerCnt[i];
                }
                
                    winners.add(i);
                
            }
        }
        System.out.println(winners);
        return winners.stream().mapToInt(Integer::intValue).toArray();
    }
}