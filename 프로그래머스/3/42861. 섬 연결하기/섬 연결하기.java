import java.util.*;

class Solution {

    //정점 v의 부모 찾기
    private int getParent(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = getParent(parent[v]);
    }

    // 정점 a,b을 연결
    private void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 다리의 건설비용 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        int totalCost = 0;
        for (int[] edge : costs) {
            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];
            // 부모가 같지 않다면
            if (getParent(v1) != getParent(v2)) {
                //둘이 연결
                union(v1, v2);
                totalCost += cost;
            }

        }
        return totalCost;

    }
}