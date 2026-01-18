class Solution {
    public int maxPower(String s) {
        int maxcount=1;
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
               maxcount= Math.max(maxcount,count);
               count=1;
            }
        }
         maxcount= Math.max(maxcount,count);
        return maxcount;
    }
}