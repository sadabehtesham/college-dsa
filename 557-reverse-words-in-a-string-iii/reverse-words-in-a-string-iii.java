class Solution {
    public String reverseWords(String s) {
        char arr[]=  s.toCharArray();
        int st=0;
        int n=arr.length;
        for(int end=0;end<=n;end++){
            if(end==n || arr[end]==' '){
                reverse(arr,st,end-1);
                st=end+1;
            }
        }
         return new String(arr);
    }
    private void reverse(char arr[],int i,int j){
            
            while(i<j){
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;

            }
           

       }  
}