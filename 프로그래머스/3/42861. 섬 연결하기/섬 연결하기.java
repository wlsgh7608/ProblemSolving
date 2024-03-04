import java.util.*;
class Solution {
    class Bridge implements Comparable<Bridge> {
        int v1;
        int v2;
        int cost;

        public Bridge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bridge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }


    int[] parent;
    List<Bridge> bridges = new ArrayList<>();

    void init(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            bridges.add(new Bridge(cost[0], cost[1], cost[2]));
        }
    }

    int getParent(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = getParent(parent[v]);
    }


    public int solution(int n, int[][] costs) {
        init(n, costs);

        int answer = 0;
        int edgeCnt = 0;
        Collections.sort(bridges);
        for (Bridge bridge : bridges) {
            if (edgeCnt == n - 1) {
                break;
            }

            int v1 = bridge.v1;
            int v2 = bridge.v2;
            int cost = bridge.cost;

            int v1Parent = getParent(v1);
            int v2Parent = getParent(v2);

            if (v1Parent != v2Parent) {
                parent[v1Parent] = v2Parent;

                answer += cost;
                edgeCnt++;
            }
        }
        return answer;
    }

}