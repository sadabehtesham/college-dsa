class Solution {
    public boolean checkIfExist(int[] nums) {
       for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==2*nums[j] ||2*nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false; 
    }
}