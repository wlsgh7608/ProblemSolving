import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Meeting {
        int s;
        int e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s, e);
        }
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1.s == o2.s) {
                return o1.e - o2.e;
            }
            return o1.s - o2.s;
        });

        int cnt = 0;
        // 최대로 겹치는 회의의 수를 구하는 문제

        PriorityQueue<Integer> PQ = new PriorityQueue<>();


        for(Meeting meeting : meetings){
            if(!PQ.isEmpty() && PQ.peek() <= meeting.s){
                PQ.poll();
            }
            PQ.add(meeting.e);
            cnt = Math.max(cnt, PQ.size());
        }
        System.out.println(cnt);


    }
}
