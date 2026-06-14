// https://leetcode.com/problems/n-queens-ii/

class Solution {
    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        int res = 0;

        public int backtrack(int row){
            if(row == n){
                res += 1;
                return;
            }

            for(int i=0; i<n; i++){
                if(col.contains(i) || posDiag.contains(row + i) || negDiag.contains(row - i)){
                    continue;
                }
                col.add(i);
                posDiag.add(row+i);
                negDiag.add(row-i);
                backtrack(row+1);
                col.remove(i);
                posDiag.remove(row+i);
                negDiag.remove(row-i);
            }
        }
        backtrack(0);
        return res;
    }
}