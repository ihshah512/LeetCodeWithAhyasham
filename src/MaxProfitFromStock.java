import java.util.*;

public class MaxProfitFromStock {

    public static int maxProfit(int[] prices) {


      /*  int findMin = prices[0];
        int findMax = prices[0];
        for(int i : prices){
            if(i < findMin){
                findMin=i;
            }
            if(i>findMax){
                findMax=i;
            }
        }
*/
        int left = 0;
        int right = prices.length;
        int profit = 0;
        while(left < right){
          /* if(prices[left]==findMax){

                left++;
              //  prices[left]=goodMax;
            }
*/

            for(int i = left+1; i < prices.length; i++){
                int buyPrice = prices[left];
                int priceDiff = prices[i]-buyPrice;
                if(priceDiff>0){
                    profit=profit + priceDiff;
                  //  left++;
                  //  i++;
                }
                left++;
               // left++;
            }

            //int diff = prices[left+1]-prices[left];



        left++;
        }
        if(profit>0){
            return profit;
        }

        return 0;
    }



    public static void main(String[] args){

        int[] arr = {7,1,5,3,6,4};

        System.out.println(maxProfit(arr));

    }
}
