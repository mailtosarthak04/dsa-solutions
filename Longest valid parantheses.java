class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // push -1 as a base index for the first valid substring
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // push index of '('
                stack.push(i);
            } else { // char is ')'
                // pop a matching '(' (or base index)
                stack.pop();
                if (stack.isEmpty()) {
                    // no base: this ')' can't be matched; set new base
                    stack.push(i);
                } else {
                    // valid substring length = current index - last unmatched index
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}