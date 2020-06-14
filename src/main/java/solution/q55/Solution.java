package solution.q55;

/**
 * 找出字符流中第一个只出现一次的字符
 */
public class Solution {
    private char[] data = new char[256];

    public void insert(char ch) {
        data[ch]++;
    }

    public char first() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                return (char) (i);
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = new String("There are moments in life when you miss someone so much that you just want to pick them from your dreams and hug them for real! Dream what you want to dream;go where you want to go;be what you want to be,because you have only one life and one chance to do all the things you want to do.");
        for (int i = 0; i < str.length(); i++) {
            solution.insert(str.charAt(i));
            System.out.println(solution.first());
        }
    }
}
