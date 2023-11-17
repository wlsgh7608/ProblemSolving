import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Trie {
        HashMap<String, Trie> hm = new HashMap<>();

        @Override
        public String toString() {
            return "Trie{" +
                    "hm=" + hm.keySet() +
                    '}';
        }

        void insert(String[] names) {
            Trie cur = this;
            for (String name : names) {
                if (!cur.hm.containsKey(name)) {
                    cur.hm.put(name, new Trie());
                }
                cur = cur.hm.get(name);
            }
        }

        void find(int depth) {
            List<String> list = new ArrayList<>(hm.keySet());
            Collections.sort(list);
            for (String name : list) {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(name).append("\n");
                hm.get(name).find(depth + 1);
            }

        }

    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String[] names = new String[M];
            for (int j = 0; j < M; j++) {
                names[j] = st.nextToken();
            }
            trie.insert(names);
        }
        trie.find(0);
        System.out.println(sb);
    }
}
