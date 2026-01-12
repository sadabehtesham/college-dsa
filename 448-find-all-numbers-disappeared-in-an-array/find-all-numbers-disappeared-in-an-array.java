class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
        List<Integer> result=new ArrayList<>();
        for(int k=0;k<nums.length;k++){
            if(nums[k]!=k+1){
                result.add(k+1);
            }
        }  
        return result;     
         
    }
}