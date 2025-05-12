import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Skill[] skills;
    static boolean isFinished = false; // 출력 후 종료를 위한 플래그
    static int minTime = Integer.MAX_VALUE;

    static class Skill {
        int time;
        int dmg;

        public Skill(int time, int dmg) {
            this.time = time;
            this.dmg = dmg;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int HP = Integer.parseInt(st.nextToken());

        skills = new Skill[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int dmg = Integer.parseInt(st.nextToken());
            skills[i] = new Skill(t, dmg);
        }

        dfs(0, HP, new int[N]);
        System.out.println(minTime);
    }

    static void dfs(int time, int hp, int[] coolTime) {
        if (time >= minTime) {
            return;
        }
        if (hp <= 0) {
            minTime = time;
            return;
        }

        boolean isNotAtk = true;

        for (int i = 0; i < N; i++) {
            if (coolTime[i] == 0) {
                isNotAtk = false;
                int[] newCoolTime = getCoolTime(0, coolTime);
                newCoolTime[i] = skills[i].time;
                dfs(time + 1, hp - skills[i].dmg, getCoolTime(1, newCoolTime));
            }
        }

        if (isNotAtk) {
            dfs(time + 1, hp, getCoolTime(1, coolTime));
        }
    }

    static int[] getCoolTime(int t, int[] arr) {
        int[] newArr = new int[N];
        for (int i = 0; i < N; i++) {
            newArr[i] = Math.max(arr[i] - t, 0);
        }
        return newArr;
    }
}
