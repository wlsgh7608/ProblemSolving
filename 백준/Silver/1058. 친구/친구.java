import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] G = new char[N][N];

        for(int i =0  ;i<N;i++){
            G[i] = br.readLine().toCharArray();
        }

        int maxFriend = 0;

        for(int i =0 ; i <N;i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j =0 ; j <N;j++){
                if(G[i][j]=='Y'){
                    hs.add(j);
                    for(int k=0;k<N;k++){
                        if(G[j][k]=='Y'){
                            hs.add(k);
                        }
                    }
                }
            }
            hs.remove(i);
            maxFriend = Math.max(maxFriend, hs.size());
        }
        System.out.println(maxFriend);

    }
}
