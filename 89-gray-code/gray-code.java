
import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();

        int total = 1 << n;

        for (int i = 0; i < total; i++) {

            int gray = i ^ (i >> 1);

            result.add(gray);
        }

        return result;
    }
}
