class Solution {
    public int peakIndexInMountainArray(int[] nums) {
         int st=1;
        int end=nums.length-1;
        while(st<end){
            int mid=st+(end-st)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1]){
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return st;
    }
}