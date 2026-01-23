class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        char[] ch= s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                st.push(')');
            }
            else if(ch[i]=='{'){
                st.push('}');
            }
            else if(ch[i]=='['){
                st.push(']');
            }
            else{
                if(st.isEmpty() || st.pop()!=ch[i]) {
                    return false;
                }

            }
        }
        return st.isEmpty();
    }
}