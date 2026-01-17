class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char a1[]=s.toCharArray();
        char a2[]=t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        int i=0;
        int j=0;
        while(i<a1.length && j<a2.length){
            if(a1[i]!=a2[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}