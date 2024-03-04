import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] answer;
    static int maxScore = 0;


    static void dfs(int cnt,int[] arr) {
        if (cnt > K) {
            return;
        }

        int score = 0;


        // 점수 계산
        for(int i = 0;i<N;i++){
            if(answer[i] == arr[i]){
                score++;
            }
        }
        maxScore = Math.max(maxScore, score);

        // 밀기 또는 당기기
        for (int i = 0; i < N; i++) {

            int[] newArr = cloneArr(arr);
            push(i,newArr);
            dfs(cnt + 1,newArr);

            newArr = cloneArr(arr);
            pull(i,newArr);
            dfs(cnt + 1,newArr);
        }

    }
    static int[] cloneArr(int[] arr){
        int[] clone = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            clone[i] = arr[i];
        }
        return clone;
    }

    static void push(int idx,int[] arr){
        for(int i = idx ; i<N-1;i++){
            arr[i] = arr[i+1];
        }
        arr[N-1] = 0;
    }

    static void pull(int idx,int[] arr){
        for(int i = N-1;i>idx;i--){
            arr[i] = arr[i-1];
        }
        arr[idx] = 0;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        int[] omr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            omr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,omr);
        System.out.println(maxScore);
    }
}
