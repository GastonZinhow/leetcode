// https://leetcode.com/problems/maximum-binary-tree/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int max = nums[0];
        int pos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }

        TreeNode root = new TreeNode(max);

        int[] leftSufix = new int[pos];
        int[] rightSufix = new int[nums.length-pos-1];

        for (int j = 0; j < pos; j++) {
            leftSufix[j] = nums[j];
        }

        for (int k = 0; k < nums.length-pos-1; k++) {
            rightSufix[k] = nums[pos+1+k];
        }

        root.left = constructMaximumBinaryTree(leftSufix);
        root.right = constructMaximumBinaryTree(rightSufix);

        return root;
    }
}