import java.sql.PreparedStatement;

public class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int n = prices[i] - prices[i - 1];
            if (n > 0) max += n;
        }
        return max;
    }

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_II_122 s = new Best_Time_to_Buy_and_Sell_Stock_II_122();
        int[] stock = {7,1,5,3,6,4};
        System.out.print(s.maxProfit2(stock));
    }
}
