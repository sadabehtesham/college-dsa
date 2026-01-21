class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
         int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            if (x == 2) {
                ans[i] = -1;
            } else {
                ans[i] = x - getLeadingOneOfLastGroupOfOnes(x);
            }
        }
        return ans;
    }
    private int getLeadingOneOfLastGroupOfOnes(int x) {
        int mask = 1;
        while ((x & mask) != 0) {
            mask <<= 1;
        }
        return mask >> 1;
    
    }
}