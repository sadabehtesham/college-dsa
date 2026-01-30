class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = original.length;

        // Map each unique string to an index
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (String s : original) if (!id.containsKey(s)) id.put(s, idx++);
        for (String s : changed)  if (!id.containsKey(s)) id.put(s, idx++);

        int m = id.size();
        long INF = (long) 1e18;
        long[][] dist = new long[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // direct conversions
        for (int i = 0; i < n; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall
        for (int k = 0; k < m; k++)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++)
                    if (dist[i][k] < INF && dist[k][j] < INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        int L = source.length();
        long[] dp = new long[L + 1];
        Arrays.fill(dp, INF);
        dp[L] = 0;

        // DP from back
        for (int i = L - 1; i >= 0; i--) {
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }

            for (String s : id.keySet()) {
                int len = s.length();
                if (i + len <= L &&
                    source.substring(i, i + len).equals(s)) {

                    for (String t : id.keySet()) {
                        int u = id.get(s), v = id.get(t);
                        if (dist[u][v] < INF &&
                            target.startsWith(t, i)) {
                            dp[i] = Math.min(dp[i], dist[u][v] + dp[i + len]);
                        }
                    }
                }
            }
        }

        return dp[0] >= INF ? -1 : dp[0];
    }
}