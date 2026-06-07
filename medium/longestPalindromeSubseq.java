// https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = 1 + dp[i][j];
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[n][m];
    }

    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        return longestCommonSubsequence(s, reversed);

    }
}