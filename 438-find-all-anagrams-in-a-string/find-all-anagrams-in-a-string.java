class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }
        int[] freq=new int[26];
        int[] fre=new int[26];
        for(int i=0;i<p.length();i++){
            int idx= p.charAt(i)-97;
            freq[idx]++;
        }
        for(int i=0;i<s.length();i++){
             int idx=s.charAt(i)-97;
             fre[idx]++;
             if(i>=p.length()){
                idx=s.charAt(i-p.length())-97;
                fre[idx]--;
             }
             if(Arrays.equals(freq,fre)){
                result.add(i-p.length()+1);
             }
        }
        return result;
    }
}