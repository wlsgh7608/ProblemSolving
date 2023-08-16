import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Integer[] arrA = new Integer[A];
        Integer[] arrB = new Integer[B];
        Integer[] arrC = new Integer[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<A;i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<B;i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<C;i++){
            arrC[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA, (o1, o2) -> (o2 - o1));
        Arrays.sort(arrB, (o1, o2) -> (o2 - o1));
        Arrays.sort(arrC, (o1, o2) -> (o2 - o1));


        int setNum = Math.min(A, B);
        setNum = Math.min(setNum, C);

        int tot = 0;
        for(int n : arrA){
            tot+=n;
        }
        for(int n : arrB){
            tot+=n;
        }
        for(int n : arrC){
            tot+=n;
        }

        int saleTot = tot;

        for(int i = 0; i<setNum;i++){
            saleTot -= arrA[i] * 0.1;
            saleTot -= arrB[i] * 0.1;
            saleTot -= arrC[i] * 0.1;
        }
        System.out.println(tot);
        System.out.println(saleTot);

    }
}
