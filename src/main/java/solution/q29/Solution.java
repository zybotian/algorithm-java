package solution.q29;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 排序,时间复杂度O(nlogn)
    public int findMoreThanHalf(int[] data) {
        if (data == null || data.length == 0) {
            throw new RuntimeException("illegal arguments");
        }

        Arrays.sort(data);
        return check(data, data[data.length >> 1]) ? data[data.length >> 1] : 0;
    }

    private boolean check(int[] data, int datum) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            count += (datum == data[i] ? 1 : 0);
        }
        return count > data.length >> 1;
    }

    // hashmap时间复杂度O(n)空间复杂度O(n)
    public int findMoreThanHalf2(int[] data) {
        if (data == null || data.length == 0) {
            throw new RuntimeException("illegal arguments");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (map.containsKey(data[i])) {
                map.put(data[i], 1 + map.get(data[i]));
            } else {
                map.put(data[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > data.length >> 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    // 时间复杂度O(n) 空间复杂度O(1)
    public int findMoreThanHalf3(int[] data) {
        if (data == null || data.length == 0) {
            throw new RuntimeException("illegal arguments");
        }

        int candidate = data[0], count = 1;
        for (int i = 1; i < data.length; i++) {
            // count变为1的数字作为备选
            if (count == 1) {
                candidate = data[i];
            }
            count += candidate == data[i] ? 1 : -1;
        }

        return check(data, candidate) ? candidate : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMoreThanHalf(new int[]{1, 2, 2, 3, 2, 4, 2, 2, 2, 5, 6}));
        System.out.println(solution.findMoreThanHalf2(new int[]{1, 2, 2, 3, 2, 4, 2, 2, 2, 5, 6}));
        System.out.println(solution.findMoreThanHalf3(new int[]{1, 2, 2, 3, 2, 4, 2, 2, 2, 5, 6}));
    }
}
