package solution.q42;

/**
 * 输入一个英文句子， 翻转句子中单词的顺序， 但单词内字符的顺序不
 * 变
 * <p>
 * 对于一个给定的字符序列 S， 请你把其循环左移 K 位后的序列输出
 */
public class Solution {

    public String reverseSentence(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return null;
        }
        char[] chars = sentence.toCharArray();
        // 整个句子当成一个大的字符产进行逆序
        reverseCharArray(chars, 0, chars.length - 1);
        // 句子中的每个单词进行逆序
        int i = 0;
        while (i < chars.length) {
            int curr = i;
            while (curr < chars.length && chars[curr] != ' ') {
                curr++;
            }
            // curr指向第一个空格
            reverseCharArray(chars, i, curr - 1);
            while (curr < chars.length && chars[curr] == ' ') {
                curr++;
            }
            i = curr;
        }
        return new String(chars);
    }

    /**
     * 字符串逆序
     *
     * @param chars
     * @param start
     * @param end
     */
    private void reverseCharArray(char[] chars, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }

    // 循环左移k位数
    public String reverseLeft(String string, int k) {
        if (string == null || string.length() == 0 || k < 0 || k > string.length()) {
            return string;
        }
        char[] chars = string.toCharArray();
        reverseCharArray(chars, 0, chars.length - 1);
        reverseCharArray(chars, 0, chars.length - k - 1);
        reverseCharArray(chars, chars.length - k, chars.length - 1);
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseSentence("we  are  happy everyday"));
        System.out.println(solution.reverseLeft("1234567", 0));

        System.out.println(solution.reverseLeft("1234567", 1));
        System.out.println(solution.reverseLeft("1234567", 2));
        System.out.println(solution.reverseLeft("1234567", 3));
        System.out.println(solution.reverseLeft("1234567", 4));
        System.out.println(solution.reverseLeft("1234567", 5));
        System.out.println(solution.reverseLeft("1234567", 6));
        System.out.println(solution.reverseLeft("1234567", 7));

    }
}
