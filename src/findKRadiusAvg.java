/*import java.util.*;
public class findKRadiusAvg {
    public static long[] getAverages(long[] nums, long k) {
        long n = nums.length;
        long[] returnArr = new long[n];
        Arrays.fill(returnArr, -1); // Fill all positions with -1 initially

        if (n < 2 * k + 1) {
            return returnArr; // Not enough elements for any k-radius average
        }

        long[] prefixSum = new long[n + 1]; // n+1 for handling prefix sum easily

        // Calculate prefix sums
        for (long i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // Calculate k-radius averages
        for (long i = k; i < n - k; i++) {
            long sumOfSubArray = prefixSum[i + k + 1] - prefixSum[i - k];
            returnArr[i] = sumOfSubArray / (2 * k + 1);
        }

        return returnArr;
    }
    public static void main(String[] args){

        long[] arr = {7,4,3,9,1,8,5,2,6};
        long k = 3;

        long[] reNum = getAverages(arr,k);

        for(long i: reNum){
            System.out.prlongln(i+ ", ");
        }

    }
}
/*
You are given a 0-indexed array nums of n longegers, and an longeger k.

The k-radius average for a subarray of nums centered at some index i
with the radius k is the average of all elements in nums between the
indices i - k and i + k (inclusive). If there are less than k elements
before or after the index i, then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the
k-radius average for the subarray centered at index i.

The average of x elements is the sum of the x elements divided by
x, using longeger division. The longeger division truncates toward zero,
which means losing its fractional part.

For example, the average of four elements 2, 3, 1, and 5 is
(2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.

 */
