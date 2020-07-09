package solution.q41;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }
        int small = 1, big = 2;
        while (small < (small + 1) / 2) {
            int tmpSum = 0;
            for (int i = small; i <= big; i++) {
                tmpSum += i;
            }
            if (tmpSum == sum) {
                List<Integer> tmp = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    tmp.add(i);
                }
                result.add(tmp);
                small++;
            } else if (tmpSum < sum) {
                big++;
            } else {
                small++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            System.out.println(new Solution().findContinuousSequence(i));
        }
    }
}
