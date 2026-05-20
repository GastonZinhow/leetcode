// https://leetcode.com/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        int sIndex = 0, tIndex = 0;
        for(int i=0; i<s.length(); i++){
            if(sChars[i] != tChars[i]){
                return false;
            }
        }
        return true;
    }
}