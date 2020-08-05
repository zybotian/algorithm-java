package solution.offer50;

import java.util.Arrays;

public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        char[] array = s.toCharArray();
        int[] result = new int[26];
        Arrays.fill(result, 0);
        for (int i = 0; i < array.length; i++) {
            result[array[i] - 'a']++;
        }

        for (int i = 0; i < array.length; i++) {
            if (result[array[i] - 'a'] == 1) {
                return array[i];
            }
        }
        return ' ';
    }
}
