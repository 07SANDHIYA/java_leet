class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];

        // Count the characters required from t
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            if (need[ch] > 0) {
                required--;
            }

            need[ch]--;
            while (required == 0) {

                int windowLength = right - left + 1;

                // Store the smallest window
                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }

                char leftChar = s.charAt(left);

                need[leftChar]++;

                // Removing this character makes the window invalid
                if (need[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}