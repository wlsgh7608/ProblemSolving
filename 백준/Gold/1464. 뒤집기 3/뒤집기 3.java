import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Deque<Character> deque = new ArrayDeque<>();


        for (char c : input.toCharArray()) {
            if (deque.isEmpty()) {
                deque.add(c);
            } else {
                if (deque.peekFirst() >= c) {
                    deque.addFirst(c);
                } else {
                    deque.addLast(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        System.out.println(sb);
    }
}
