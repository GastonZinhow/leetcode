class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> duplicate = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer duplicateIndex = duplicate.get(nums[i]);
            if(duplicateIndex != null){
                return true;
            }
            duplicate.put(nums[i], i);

        }
        return false;
    }
}