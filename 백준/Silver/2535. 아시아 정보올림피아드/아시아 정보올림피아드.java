import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        int c;
        int n;
        int score;

        public Student(int c, int n, int score) {
            this.c = c;
            this.n = n;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            list.add(new Student(c, n, score));
        }
        Collections.sort(list);

        HashMap<Integer, Integer> hm = new HashMap<>();

        int ans = 0;


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (ans == 3) {
                break;
            }
            int c = list.get(i).c;
            if (hm.containsKey(c)) {
                if (hm.get(c) < 2) {
                    sb.append(list.get(i).c + " " + list.get(i).n).append("\n");
                    ans++;
                    hm.put(c, hm.get(c) + 1);
                }

            } else {
                hm.put(c, 1);
                ans++;
                sb.append(list.get(i).c + " " + list.get(i).n).append("\n");
            }
        }
        System.out.println(sb);


    }
}
