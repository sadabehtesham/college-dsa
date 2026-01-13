class Solution {
    public int[] findErrorNums(int[] nums) {
        int i=0;
        while(i<nums.length){
            int j=nums[i]-1;
            if(nums[i]!=nums[j]){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            else{
                i++;
            }
        }
        for(int k=0;k<nums.length;k++){
            if(nums[k]!=k+1){
                return new int[] { nums[k], k+1};
            }
        }
        return new int[] {-1,-1};
    }
}