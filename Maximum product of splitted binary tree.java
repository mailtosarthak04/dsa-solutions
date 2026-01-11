class Solution {
    private long totalSum = 0;
    private List<Long> subtreeSums = new ArrayList<>();
    private static final long MOD = 1000000007L;

    public int maxProduct(TreeNode root) {
        totalSum = computeSum(root);
        computeSubtreeSums(root);
        
        long maxProduct = 0;
        for (long sum : subtreeSums) {
            long complement = totalSum - sum;
            maxProduct = Math.max(maxProduct, sum * complement);
        }
        return (int)(maxProduct % MOD);
    }
    private long computeSum(TreeNode node) {
        if (node == null) return 0;
        long sum = node.val + computeSum(node.left) + computeSum(node.right);
        return sum;
    }
    private long computeSubtreeSums(TreeNode node) {
        if (node == null) return 0;
        long leftSum = computeSubtreeSums(node.left);
        long rightSum = computeSubtreeSums(node.right);
        long subtreeSum = node.val + leftSum + rightSum;
        subtreeSums.add(subtreeSum);
        return subtreeSum;
    }
}