import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length() / 3;
        String[] cards = new String[size];
        for (int i = 0; i < size; i++) {
            cards[i] = input.substring(i * 3, (i + 1) * 3);
        }
        HashSet<String> hs = new HashSet<>();
        for (String card : cards) {
            hs.add(card);
        }
        if (hs.size() == size) {
            int p = 13;
            int k = 13;
            int h = 13;
            int t = 13;
            for (String card : cards) {
                char c = card.charAt(0);
                c = Character.toLowerCase(c);
                switch (c) {
                    case 'p':
                        p--;
                        break;
                    case 'k':
                        k--;
                        break;
                    case 'h':
                        h--;
                        break;
                    case 't':
                        t--;
                        break;
                }
            }
            System.out.println(p + " " + k + " " + h + " " + t);

        } else {
            System.out.println("GRESKA");
        }


    }
}
