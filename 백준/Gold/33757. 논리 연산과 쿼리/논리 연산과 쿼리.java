import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        String expr = br.readLine();

        int[] values = new int[N];
        char[] ops = new char[N - 1];

        // 논리값과 연산자 분리
        for (int i = 0; i < N; i++) {
            values[i] = expr.charAt(2 * i) - '0';
            if (i < N - 1) {
                ops[i] = expr.charAt(2 * i + 1);
            }
        }


        int[] groupId = new int[N];
        int g = 0;
        for (int i = 0; i < N; i++) {
            groupId[i] = g;
            if (i < N - 1 && ops[i] == '|') {
                g++;
            }
        }
        int M = g + 1; // 그룹 개수

        // 그룹별 크기 및 1의 개수
        int[] groupSize = new int[M];
        int[] groupOnes = new int[M];
        for (int i = 0; i < N; i++) {
            int gid = groupId[i];
            groupSize[gid]++;
            groupOnes[gid] += values[i];
        }


        int[] groupVal = new int[M];
        int activeGroups = 0;
        for (int i = 0; i < M; i++) {
            groupVal[i] = (groupOnes[i] == groupSize[i]) ? 1 : 0;
            if (groupVal[i] == 1) activeGroups++;
        }

        StringBuilder sb = new StringBuilder();

        int [] newIdx = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i= 0 ; i<Q;i++){
            newIdx[i] = Integer.parseInt(st.nextToken())-1;
        }


        for (int q = 0; q < Q; q++) {
            int k = newIdx[q];// 0-based index
            int gid = groupId[k];

            int oldGroupVal = groupVal[gid];

            if (values[k] == 1) {
                values[k] = 0;
                groupOnes[gid]--;
            } else {
                values[k] = 1;
                groupOnes[gid]++;
            }


            int newGroupVal = (groupOnes[gid] == groupSize[gid]) ? 1 : 0;
            groupVal[gid] = newGroupVal;


            if (oldGroupVal == 0 && newGroupVal == 1) activeGroups++;
            else if (oldGroupVal == 1 && newGroupVal == 0) activeGroups--;


            sb.append((activeGroups > 0) ? 1 : 0);
        }

        System.out.print(sb);
    }
}
