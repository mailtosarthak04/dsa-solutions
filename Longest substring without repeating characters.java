class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // If character already in set, move left until it's removed
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c); // add current character
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}