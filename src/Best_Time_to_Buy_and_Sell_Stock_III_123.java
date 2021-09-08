public class Best_Time_to_Buy_and_Sell_Stock_III_123 {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];

        for (int i = 0; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int k = 1; k < 3; k++) {
            dp[0][k][1] = -prices[0];
            dp[0][k][0] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            for(int k = 1; k < 3; k++) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][2][0];
    }


    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_III_123 s = new Best_Time_to_Buy_and_Sell_Stock_III_123();
        int[] stock = {7,1,5,3,6,4};
        System.out.print(s.maxProfit(stock));
    }
}
