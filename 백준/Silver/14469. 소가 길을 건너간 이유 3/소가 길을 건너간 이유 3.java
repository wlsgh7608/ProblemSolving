import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Cow implements Comparable<Cow> {
        int start;
        int time;

        public Cow(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Cow o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Cow[] arr = new Cow[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr[i] = new Cow(start, time);
        }
        Arrays.sort(arr);
        int curTime = 0;
        for (Cow cow : arr) {
            if (cow.start < curTime) {
                curTime += cow.time;
            } else {

                curTime = cow.start + cow.time;
            }
        }
        System.out.println(curTime);

    }
}
