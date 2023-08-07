import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word>{
        String name;
        int count;
        int len;

        public Word(String name, int count, int len) {
            this.name = name;
            this.count = count;
            this.len = len;
        }

        @Override
        public int compareTo(Word o) {
            if(this.count==o.count){
                if(o.len==this.len){
                    return this.name.compareTo(o.name);
                }
                return o.len-this.len;
            }
            return o.count-this.count;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i<N;i++){
            String name = br.readLine();
            if(name.length()<M){
                continue;
            }
            hm.put(name, hm.getOrDefault(name, 0)+1);
        }
        List<Word> list = new ArrayList<>();
        for(String key: hm.keySet()){
            list.add(new Word(key, hm.get(key), key.length()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Word w : list){
            sb.append(w.name).append("\n");
        }
        System.out.println(sb);


    }

}
