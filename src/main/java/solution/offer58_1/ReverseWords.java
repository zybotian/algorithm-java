package solution.offer58_1;

/**
 * 输入一个英文句子， 翻转句子中单词的顺序， 但单词内字符的顺序不, 要求去掉句子的左边和右边空格， 句子内多个空格仅保留一个
 * 变
 *
 * @link https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * <p>
 * 对于一个给定的字符序列 S， 请你把其循环左移 K 位后的序列输出
 */
public class ReverseWords {

    public String reverseWords(String s) {
        // 合法性检查
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return "";
        }

        // 去掉左右两边空格,转成字符数组
        char[] chars = s.trim().toCharArray();

        // 句子整体翻转
        reverseWord(chars, 0, chars.length - 1);

        int i = 0, j = 0;
        StringBuilder result = new StringBuilder();
        while (i < chars.length) {
            // 跳过左边空格
            while (i < chars.length && chars[i] == ' ') {
                i++;
            }
            j = i;
            // 寻找右边第一个空格
            while (j < chars.length && chars[j] != ' ') {
                j++;
            }
            if (i < chars.length) {
                // 单词翻转
                String tmp = reverseWord(chars, i, j - 1);
                result.append(tmp + " ");
                i = j;
            } else {
                break;
            }
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }

    public String reverseWord(char[] chars, int left, int right) {
        if (chars == null || chars.length == 0 || left < 0 || left > chars.length || right < 0 || right > chars.length || left > right) {
            return "";
        }
        int start = left, end = right;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars, left, right - left + 1);
    }

    public String reverseWords2(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return "";
        }
        s = reverseWord2(s);
        String[] words = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(reverseWord2(words[i]) + " ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public String reverseWord2(String word) {
        if (word == null || word.length() == 0 || word.trim().length() == 0) {
            return "";
        }
        int i = 0, j = word.length() - 1;
        char[] chs = word.toCharArray();
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chs);
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords2(""));
        System.out.println(reverseWords.reverseWords2("     "));
        System.out.println(reverseWords.reverseWords2("we are happy!"));
        System.out.println(reverseWords.reverseWords2("we     are  happy!"));
        System.out.println(reverseWords.reverseWords2("we     are  happy! "));

        System.out.println(reverseWords.reverseWords2("we     arehappy! "));

        System.out.println(reverseWords.reverseWords2("we"));
        System.out.println(reverseWords.reverseWords2("w"));
    }
}
