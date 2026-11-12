// https://leetcode.com/problems/palindrome-number/description/

class Solution {
    public boolean isPalindrome(int x) {
        String z = String.valueOf(x);
        char[] y = z.toCharArray();
        int reverse = y.length-1;
        for(int i=0;i<y.length;i++){
            if(y[i] != y[reverse]) return false;
            reverse--;
        }
        return true;
    }
}