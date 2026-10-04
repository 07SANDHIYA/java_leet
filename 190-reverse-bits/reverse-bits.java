class Solution {
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            // Get the last bit of n
            int bit = n & 1;

            // Shift result left
            result = result << 1;

            // Add the extracted bit
            result = result | bit;

            // Move n to the right
            n = n >>> 1;
        }

        return result;
    }
}