/*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3]
Input 2:

A = [2]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 Only choice is to take both elements.
Explanation 2:

 Take the whole array.

 */


public class Solution {
    public int solve(int[] A) {
        if(A.length <= 2) return A.length;
        // Maintain trackers
        int minIdx = -1, mi = Integer.MAX_VALUE;
        int maxIdx = -1, ma = Integer.MIN_VALUE;
        // find the first indices of min and max occurences in the array
        for(int i = 0; i < A.length; i++){
            if(A[i] < mi){
                minIdx = i;
                mi = A[i];
            }
            if(A[i] > ma){
                maxIdx = i;
                ma = A[i];
            }
        }
        //System.out.println("mi: "+ mi + " miIdx: "+ minIdx + " maxIdx: "+ maxIdx + " ma: "+ma);
        int minDist = Math.abs(ma - mi + 1);
        // Iterate over the array for the closest minIdx and maxIdx
        for(int i = 0; i < A.length; i++){
            if(A[i] == mi){
                minIdx = i;
            }
            if(A[i] == ma){
                maxIdx = i;
            }
            minDist = Math.min(minDist, Math.abs(maxIdx - minIdx)+1);
        }
        return minDist;
    }
}
