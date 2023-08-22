import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> zeroMinStick = new HashMap<>();
        zeroMinStick.put(2, 1);
        zeroMinStick.put(3, 7);
        zeroMinStick.put(4, 4);
        zeroMinStick.put(5, 2);
        zeroMinStick.put(6, 0);
        zeroMinStick.put(7, 8);

        HashMap<Integer, Integer> minStick = new HashMap<>();
        minStick.put(2, 1);
        minStick.put(3, 7);
        minStick.put(4, 4);
        minStick.put(5, 2);
        minStick.put(6, 6);
        minStick.put(7, 8);


        String[] min = new String[101];
        String[] zeroMin = new String[101];
        String[] max = new String[101];
        for (int n : minStick.keySet()) {
            min[n] = "" + minStick.get(n);
        }
        for (int n : zeroMinStick.keySet()) {
            zeroMin[n] = "" + zeroMinStick.get(n);
        }
        String temp = "";
        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                max[i] = "1" + temp;
            } else {
                max[i] = "7" + temp;
                temp += "1";
            }
        }

        for (int i = 7; i <= 100; i++) {
            for (int key : zeroMinStick.keySet()) {
                int value = zeroMinStick.get(key);
                if (zeroMin[i - key] == null) {
                    continue;
                }
                String tmp = "" + value + zeroMin[i - key];
                if (zeroMin[i] == null) {
                    zeroMin[i] = tmp;
                }

                if (zeroMin[i].length() > tmp.length()) {
                    zeroMin[i] = tmp;
                } else if (zeroMin[i].length() == tmp.length()) {
                    if (Long.parseLong(zeroMin[i]) > Long.parseLong(tmp)) {
                        zeroMin[i] = tmp;
                    }
                }


            }

            for (int key : minStick.keySet()) {
                int value = minStick.get(key);
                if (zeroMin[i - key] == null) {
                    continue;
                }
                String tmp = "" + value + zeroMin[i - key];
                String tmp2 = "" + value + min[i - key];
                if (Long.parseLong(tmp2) < Long.parseLong(tmp)) {
                    tmp = tmp2;
                }
                if (min[i] == null) {
                    min[i] = tmp;
                }
                if (Long.parseLong(min[i]) > Long.parseLong(tmp)) {
                    min[i] = tmp;
                }
            }
        }
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(min[N] + " " + max[N]).append("\n");

        } // end for
        System.out.println(sb);
    }
}
