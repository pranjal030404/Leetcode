// Given an integer array nums, find a subarray that has the largest product, and return the product.

// The test cases are generated so that the answer will fit in a 32-bit integer

class Solution {
    public int maxProduct(int[] arr) {
        if (arr.length == 0)
            return 0;

        int maxP = arr[0], minP = arr[0], res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxP;
                maxP = minP;
                minP = temp;
            }

            maxP = Math.max(arr[i], maxP * arr[i]);
            minP = Math.min(arr[i], minP * arr[i]);

            res = Math.max(res, maxP);
        }

        return res;
    }

}