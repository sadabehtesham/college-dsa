class Solution {
    public int maxProfit(int[] prices) {
        int buyprice=prices[0];
        int maxp=0;
        for(int i=1;i<prices.length;i++){
            if(buyprice<prices[i]){
                int profit=prices[i]-buyprice;
                maxp=Math.max(maxp,profit);
            }
            else{
                buyprice=prices[i];
            }
        }
        return maxp;
    }
}