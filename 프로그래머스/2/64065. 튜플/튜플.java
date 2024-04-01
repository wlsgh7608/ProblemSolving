import java.util.*;

public class Solution {


    private  HashSet<Integer> getArr(String s){
        StringTokenizer st = new StringTokenizer(s,",");
//        int[] arr = new int[st.countTokens()];
        int idx = 0;

        HashSet<Integer> hs = new HashSet<>();
        while(st.hasMoreTokens()){
            hs.add(Integer.parseInt(st.nextToken()));
//            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        return hs;
    }
    private int[] getContent(String s){
        StringTokenizer st = new StringTokenizer(s,"{}");
        // 나누어진 토큰 {} , {} , {} , {}
        List<HashSet<Integer>> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if (token.equals(",")) {
                continue;
            }
            list.add(getArr(token));
        }
        Collections.sort(list,( o1, o2) -> o1.size() - o2.size());
//        return list
        int idx = 0;

        int[] result = new int[list.size()];

        HashSet<Integer> cur = new HashSet<>();

        for(HashSet<Integer> hs : list){
//            result[idx++] = arr[0];
            hs.removeAll(cur);
            int remain = hs.iterator().next();
            result[idx++] = remain;
            cur.add(remain);
//            System.out.println(idx++ + " : " + arr);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public int[] solution(String s) {
        // 가장 바깥의 괄호 제거
        s = s.substring(1, s.length() - 1);
        return getContent(s);

//        System.out.println(s);
//        int[] answer = {};
//        return answer;
    }


}
