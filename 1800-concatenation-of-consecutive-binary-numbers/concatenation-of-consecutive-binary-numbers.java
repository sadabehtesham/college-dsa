class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int bits = 0;
        int MOD = 1_000_000_007;

        for (int i = 1; i <= n; i++) {
            // if power of two → new bit length
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            res = ((res << bits) | i) % MOD;
        }

        return (int) res;
    }
}