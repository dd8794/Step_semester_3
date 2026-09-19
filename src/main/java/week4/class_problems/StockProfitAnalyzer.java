package week4.class_problems;

public class StockProfitAnalyzer {

    static int maxProfit(int[] prices) {

        int minimumPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minimumPrice) {
                minimumPrice = prices[i];
            }

            int currentProfit = prices[i] - minimumPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }
}