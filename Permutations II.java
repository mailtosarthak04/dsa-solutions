class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, ans);
        return ans;
    }
    private void backtrack(int idx, int[] nums, List<List<Integer>> ans) {
        if (idx == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int x : nums) perm.add(x);
            ans.add(perm);
            return;
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = idx; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            used.add(nums[i]);

            swap(nums, idx, i);
            backtrack(idx + 1, nums, ans);
            swap(nums, idx, i);  // undo
        }
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}