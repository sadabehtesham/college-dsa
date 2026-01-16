class Solution {
    public int searchInsert(int[] nums, int target) {
         int st=0;
        int end=nums.length;
        while(st<end){
            int mid=st+(end-st)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end--;
            }
            else{
                st++;
            }
        }
        return st;
    }
}