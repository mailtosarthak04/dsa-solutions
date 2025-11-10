class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int k = 2; // Start from the third position
        for (int i = 2; i < nums.length; i++) {
            // Only add the number if it's not equal to the element at k-2
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}