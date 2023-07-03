import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int parent;
        int l;
        int r;
        int loc;

        public Node(int l, int r) {
            this.parent = -1;
            this.l = l;
            this.r = r;
        }


        @Override
        public String toString() {
            return "Node{" +
                    ", l=" + l +
                    ", r=" + r +
                    ", loc=" + loc +
                    '}';
        }
    }

    static Node[] nodes;
    static int loc;
    static int N;
    static int maxLevel = 0;
    static int maxWidth = 0;
    static List<Integer>[] adjList;


    static void inOrder(int v) {
        Node cur = nodes[v];
        if (cur.l != -1) {
            inOrder(cur.l);
        }
        cur.loc = loc++;
        if (cur.r != -1) {
            inOrder(cur.r);
        }
    }

    static void bfs(int v) {
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(v);


        int level = 1;
        int width = 0;
        while (!Q.isEmpty()) {
            int qSize = Q.size();

            int curLeft = 10_000_000;
            int curRight = 0;


            for (int i = 0; i < qSize; i++) {
                int cur = Q.poll();
                Node node = nodes[cur];
                if (curLeft > node.loc) {
                    curLeft = node.loc;
                }
                if (curRight < node.loc) {
                    curRight = node.loc;
                }
                if (node.l != -1) {
                    Q.add(node.l);
                }
                if (node.r != -1) {
                    Q.add(node.r);
                }
            } // end for
            width = curRight - curLeft + 1;

            if (width > maxWidth) {
                maxWidth = width;
                maxLevel = level;
            }
            level++;
        }
    }


    static void process(int v) {
        loc = 1;
        inOrder(v);
        bfs(v);

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            nodes[i] = new Node(-1, -1);
        }


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nodes[n].l = l;
            nodes[n].r = r;

            if (l != -1) {
                nodes[l].parent = n;
            }
            if (r != -1) {
                nodes[r].parent = n;
            }
        } // end input

        int rootIdx = -1;
        for (int i = 1; i <= N; i++) {
            if (nodes[i].parent == -1) {
                rootIdx = i;
            }
        }
        process(rootIdx);
        System.out.println(maxLevel + " " + maxWidth);


    }
}
