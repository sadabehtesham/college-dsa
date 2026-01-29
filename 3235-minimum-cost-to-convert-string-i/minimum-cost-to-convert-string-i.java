class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int N = 26;
        long INF = (long) 1e18;
        long[][] dist = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

         
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (s != t) {
                if (dist[s][t] == INF) return -1;
                totalCost += dist[s][t];
            }
        }

        return totalCost;
    }
}