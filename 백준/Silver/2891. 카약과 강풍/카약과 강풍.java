import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        HashSet<Integer> broken = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            broken.add(Integer.parseInt(st.nextToken()));
        }

        HashSet<Integer> reserve = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            reserve.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            if (broken.contains(i) && reserve.contains(i)) {
                broken.remove(i);
                reserve.remove(i);
            }
        }

        List<Integer> brokenList = new ArrayList<>(broken);
        Collections.sort(brokenList);

        for(int idx : brokenList){
            if(reserve.contains(idx-1)){
                reserve.remove(idx-1);
                broken.remove(idx);
            }else if(reserve.contains(idx+1)){
                reserve.remove(idx+1);
                broken.remove(idx);
            }
        }
        System.out.println(broken.size());


    }
}
