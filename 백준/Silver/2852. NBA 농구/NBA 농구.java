import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int getSecond(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        return 60 * m + s;
    }

    private static String displaySecond(int time) {
        int m = time / 60;
        int s = time % 60;

        String minuteFormat = String.format("%02d", m);
        String secondFormat = String.format("%02d", s);

        return minuteFormat + ":" + secondFormat;
    }


    private static void addSecond(int second, int winIdx, int[] winSecond) {
        winSecond[winIdx] += second;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] winScore = new int[3];
        int[] winSecond = new int[3];

        int currentWinTeam = 0;

        int currentGoalTime = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int winTeam = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            int second = getSecond(str);

            int diff = second - currentGoalTime;

            addSecond(diff, currentWinTeam, winSecond);

            winScore[winTeam]++;
            if (winScore[1] > winScore[2]) {
                currentWinTeam = 1;
            } else if (winScore[1] < winScore[2]) {
                currentWinTeam = 2;
            } else {
                currentWinTeam = 0;
            }
            currentGoalTime = second;
        } // end for

        int lastDiff = 48 * 60 - currentGoalTime;
        addSecond(lastDiff, currentWinTeam, winSecond);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2; i++) {
            String displayTime = displaySecond(winSecond[i]);
            sb.append(displayTime).append("\n");
        }
        System.out.println(sb);
    }
}
