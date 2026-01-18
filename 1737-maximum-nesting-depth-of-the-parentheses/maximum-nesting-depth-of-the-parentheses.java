class Solution {
    public int maxDepth(String s) {
        int curr=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                curr++;
                res=Math.max(curr,res);
            }
            else if(ch==')'){
                curr--;
            }
        }
        return res;
    }
}