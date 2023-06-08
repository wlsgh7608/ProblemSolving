import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(br.readLine());


        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            left.add(input.charAt(i));
        }

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.equals("L")) {
                if(!left.isEmpty()){
                    char a = left.pop();
                    right.push(a);
                }
            } else if (command.equals("D")) {
                if(!right.isEmpty()){
                    char a = right.pop();
                    left.push(a);
                }
            } else if (command.equals("B")) {
                if(!left.isEmpty()){
                    left.pop();
                }
            } else {
                StringTokenizer st = new StringTokenizer(command);
                st.nextToken();
                String add = st.nextToken();
                left.push(add.charAt(0));
            }

        }
        StringBuilder sb = new StringBuilder();
        for(char c : left){
            sb.append(c);
        }
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);


    }
}
