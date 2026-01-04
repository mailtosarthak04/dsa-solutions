class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;
        
        for (int num : nums) {
            int sum = 0, count = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    sum += i;
                    count++;
                    
                    if (i * i != num) {
                        sum += num / i;
                        count++;
                    }
                }
            }
            if (count == 4) {
                total += sum;
            }
        }
        return total;
    }
}