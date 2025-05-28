class twosum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            Integer seenIndex = seen.get(nums[i]);
            if(seenIndex != null){
                return new int[]{i, seenIndex};
            }
            seen.put(target-nums[i], i);
        }
        return nums;
        
    }
}