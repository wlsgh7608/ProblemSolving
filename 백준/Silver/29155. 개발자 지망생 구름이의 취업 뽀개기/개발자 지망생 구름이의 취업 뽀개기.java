import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solvedProblems = new int[6];
        List<Integer>[] problems = new List[6];
        for (int i = 1; i <= 5; i++) {
            problems[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 5; i++) {
            solvedProblems[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            problems[level].add(time);
        }

        for (int i = 1; i <= 5; i++) {
            Collections.sort(problems[i]);
        }


        int result = 0;

        int prevLevel = 6;
        int prevTime = 0;
        for (int i = 1; i <= 5; i++) {
            int num = solvedProblems[i];
            for (int j = 0; j < num; j++) {

                int curTime = problems[i].get(j);
                if (prevLevel < i) {
                    result += 60;
                } else if (prevLevel == i) {
                    result += curTime - prevTime;
                }
                result += curTime;
                prevTime = curTime;
                prevLevel = i;
            }
        }

        System.out.println(result);


    }
}
