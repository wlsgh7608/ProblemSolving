import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Tree implements Comparable<Tree> {
        int h;
        int g;

        public Tree(int h, int g) {
            this.h = h;
            this.g = g;
        }

        @Override
        public int compareTo(Tree o) {
            return this.g - o.g;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] height = new int[N];
        int[] grow = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }
        Tree[] trees = new Tree[N];
        for (int i = 0; i < N; i++) {
            trees[i] = new Tree(height[i], grow[i]);
        }
        Arrays.sort(trees);

        long result = 0;
        for (int i = 0; i < N; i++) {
            Tree tree = trees[i];
            result += tree.h + (long) tree.g * i;
        }
        System.out.println(result);

    }


}
