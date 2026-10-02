class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int[] res = new int[set.size()];

        int index = 0;

        for (int r : set) {
            res[index] = r;
            index++;
        }

        Arrays.sort(res);

        int current = 1;
        int longest = 1;

        for (int i = 1; i < res.length; i++) {

            if (res[i] == res[i - 1] + 1) {
                current++;
            } else {
                current = 1;
            }

            longest = Math.max(longest, current);
        }

        return longest;
    }
}