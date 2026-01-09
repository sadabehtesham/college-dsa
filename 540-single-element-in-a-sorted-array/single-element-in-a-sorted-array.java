class Solution {
    public int singleNonDuplicate(int[] nums) {
        int arr=0;
        for(int i=0; i<nums.length;i++){
            arr=arr ^ nums[i];
        }
        return arr;
    }
}