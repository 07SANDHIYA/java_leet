class Solution {
    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }

        int answer = 10;
        int unique = 9;
        int available = 9;

        for (int digits = 2; digits <= n; digits++) {

            unique = unique * available;

            answer = answer + unique;

            available--;
        }

        return answer;
    }
}