class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
         int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (existsSquare(prefix, m, n, mid, threshold)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean existsSquare(int[][] prefix, int m, int n, int len, int threshold) {
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                int sum = prefix[i][j]
                        - prefix[i - len][j]
                        - prefix[i][j - len]
                        + prefix[i - len][j - len];
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}