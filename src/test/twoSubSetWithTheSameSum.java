package test;


import java.util.Arrays;

public class twoSubSetWithTheSameSum {
    // Time Complexity - O(nk)
    // Space Complexity - O(n^2)
    public static boolean twoSubSetWithTheSameSum(int[] S) {
        int sum = Arrays.stream(S).sum();
        if(sum%2!=0) {
            return false;
        } else {
            return findSubset(S,(sum/2));
        }
    }
    public static boolean findSubset(int[] arr, int k) {
        boolean[][] dp = new boolean[arr.length + 1][k + 1]; // Space Complexity - O(nk)
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= arr.length; i++) {     // Time Complexity - O(n^2)
            for (int j = 1; j <= k; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[arr.length][k];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println("The Result of the 2 Subset with the same value is: " + twoSubSetWithTheSameSum(arr));
    }

}
