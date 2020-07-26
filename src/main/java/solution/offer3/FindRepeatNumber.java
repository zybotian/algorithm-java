package solution.offer3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Map<Integer, Integer> dataCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dataCountMap.put(nums[i], dataCountMap.containsKey(nums[i]) ? dataCountMap.get(nums[i]) + 1 : 1);
        }

        for (Map.Entry<Integer, Integer> entry : dataCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
