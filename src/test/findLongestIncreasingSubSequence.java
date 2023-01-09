package test;

public class findLongestIncreasingSubSequence {
    // Time-Complexity : O(n^2)
    // Space-Complexity : O(n)

    public static int findLongestIncreasingSubSequence(int[] arr){

        int[] maxUntilIndex = new int[arr.length]; // Create new array in the same size of the given array. O(n) - Space Complexity
        int maxLength = 0;

        for(int i=0 ; i < arr.length ; i++) {       // Compare the Values and use the Remember Array. O(n^2) - Time Complexity
            maxUntilIndex[i] = 1;             // the minimum length is 1
            for(int j = 0; j < i ; j++) {
                if(arr[i] > arr[j] && maxUntilIndex[i] < maxUntilIndex[j] + 1){
                    maxUntilIndex[i] = maxUntilIndex[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, maxUntilIndex[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        int calcLongestSubSequence = findLongestIncreasingSubSequence(arr);
        System.out.println("The length of the Longest Increasing Sub-Sequence is: " + calcLongestSubSequence);
    }
}
