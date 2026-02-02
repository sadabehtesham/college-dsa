class Solution {
    public int finalElement(int[] nums) {
        int n = nums.length;
        int f=nums[0];
        int l=nums[n-1];
        int ans=Math.max(f,l);
        return ans; 
    }
}