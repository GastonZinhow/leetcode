// https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        char[] x = first.toCharArray();
        String last = strs[strs.length-1];
        char[] y = last.toCharArray();
        String ans="";
        for(int i=0;i<first.length();i++){
            if(x[i] != y[i]){
                return ans;
            }
            ans = ans + x[i];
        }
        return ans;
    }
}