class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int st=0;
        int end=numbers.length-1;
        while(st<end){
            if(numbers[st] +numbers[end]==target){
                return new int[] {st+1, end+1};
            }
           
            if(numbers[st] +numbers[end]>target){
                end--;
            }
            else{
                st++;
            }
        }
        
        return new int[]{-1,-1};
    }
}