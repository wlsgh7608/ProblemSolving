import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Haybale implements Comparable<Haybale>{
        int idx;
        int s;

        public Haybale(int idx, int s) {
            this.idx = idx;
            this.s = s;
        }

        @Override
        public int compareTo(Haybale o) {
            return this.s-o.s;
        }
    }

    static int getParent(int v){
        if(parent[v] == v){
            return v;
        }
        return parent[v] = getParent(parent[v]);

    }

    static void union(int a, int b){
        a = getParent(a);
        b = getParent(b);

        parent[b] = a;
        flavorSum[a] += flavorSum[b];
    }

    static int[] parent;
    static long[] flavorSum;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        Haybale[] haybale = new Haybale[N + 1];
        flavorSum = new long[N + 1];
        parent = new int[N + 1];
        List<Haybale> spicySorted = new ArrayList<>();


        for(int i= 1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            flavorSum[i] = f;
            parent[i] = i;


            haybale[i] = new Haybale(i,s);
            spicySorted.add(new Haybale(i, s));
        }
        Collections.sort(spicySorted);

        for(Haybale h : spicySorted){
            int curIdx = h.idx;
            int spicy = h.s;

            int before = curIdx-1;
            int next = curIdx +1;

            if(before>=1 && haybale[before].s<=spicy){
                union(curIdx,before);
            }
            if(next<=N && haybale[next].s<=spicy){
                union(curIdx, next);
            }
            if(flavorSum[curIdx]>=M){
                System.out.println(spicy);
                break;
            }
        }
    }
}
