package org.example;

import static java.lang.Math.max;

/**
 * @author Administrator
 */
public class s121 {
    public int maxProfit(int[] prices) {
        //a,b为未持有股票和持有股票的最大利润
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            }else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
