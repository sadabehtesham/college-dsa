class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;

        long NEG = -(long)1e18;

        long ans = NEG;

        long prev = nums[0];

        long a = NEG; 
        long b = NEG; 
        long c = NEG; 

        for (int i = 1; i < n; i++) {
            long newA = NEG;
            long newB = NEG;
            long newC = NEG;

            long curr = nums[i];

            if (curr > prev) {
                newA = Math.max(a, prev) + curr;
                newC = Math.max(b, c) + curr;
            } 
            else if (curr < prev) {
                newB = Math.max(b, a) + curr;
            }

            a = newA;
            b = newB;
            c = newC;

            ans = Math.max(ans, c);

            prev = curr;
        }

        return ans;
    }
}