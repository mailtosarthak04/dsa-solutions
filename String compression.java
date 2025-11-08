class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            // Check if we're at the end of a group of the same character
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int count = read - left + 1;
                if (count > 1) {
                    // Write count as separate digits
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                left = read + 1; // Move to the next group
            }
        }
        return write;
    }
}