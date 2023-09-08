import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Load implements  Comparable<Load>{
        int a;
        int b;
        int t;

        public Load(int a, int b, int t) {
            this.a = a;
            this.b = b;
            this.t = t;
        }
        public int compareTo(Load o){
            return this.t-o.t;
        }

    }
    static int getParent(int v){
        if(parent[v]== v){
            return v;
        }
        return parent[v] = getParent(parent[v]);
    }

    static void  union(int a, int b) {
        parent[b] = a;
    }

    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for(int i =1 ; i<=N;i++){
            parent[i] = i;
        }
        int result = 0;
        List<Load> list = new ArrayList<>();

        for(int i = 0 ;i <M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new Load(a, b, t));
        }
        int cnt= 0;
        Collections.sort(list);
        for(Load cur : list){
            if(cnt==N-2){
                break;
            }
            int a = getParent(cur.a);
            int b = getParent(cur.b);
            if(a!=b){
                cnt++;
                union(a, b);
                result+=cur.t;
            }
        }
        System.out.println(result);
    }
}
