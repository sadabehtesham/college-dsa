class Solution {
    static class State {
        int cost, r, c, t;
        State(int cost, int r, int c, int t) {
            this.cost = cost;
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = Integer.MAX_VALUE / 2;

        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], INF);

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(grid[i][j], x -> new ArrayList<>())
                   .add(new int[]{i, j});
            }
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        int[] teleportUsedUntil = new int[k + 1];
        Arrays.fill(teleportUsedUntil, -1);

        List<Integer> values = new ArrayList<>(map.keySet());

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int cost = cur.cost, r = cur.r, c = cur.c, t = cur.t;

            if (cost > dist[r][c][t]) continue;

            if (r == m - 1 && c == n - 1) {
                return cost;
            }

            if (r + 1 < m) {
                int nc = cost + grid[r + 1][c];
                if (nc < dist[r + 1][c][t]) {
                    dist[r + 1][c][t] = nc;
                    pq.offer(new State(nc, r + 1, c, t));
                }
            }

            if (c + 1 < n) {
                int nc = cost + grid[r][c + 1];
                if (nc < dist[r][c + 1][t]) {
                    dist[r][c + 1][t] = nc;
                    pq.offer(new State(nc, r, c + 1, t));
                }
            }

            if (t < k) {
                int val = grid[r][c];
                int idx = upperBound(values, val);

                if (teleportUsedUntil[t] < idx) {
                    for (int i = teleportUsedUntil[t] + 1; i <= idx; i++) {
                        for (int[] cell : map.get(values.get(i))) {
                            int x = cell[0], y = cell[1];
                            if (cost < dist[x][y][t + 1]) {
                                dist[x][y][t + 1] = cost;
                                pq.offer(new State(cost, x, y, t + 1));
                            }
                        }
                    }
                    teleportUsedUntil[t] = idx;
                }
            }
        }

        return -1;
    }

    private int upperBound(List<Integer> arr, int target) {
        int l = 0, r = arr.size() - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
