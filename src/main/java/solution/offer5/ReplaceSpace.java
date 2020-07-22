package solution.offer5;

public class ReplaceSpace {

    public String replaceSpace(String s) {
        return s == null ? "" : s.replaceAll("\\s", "%20");
    }

    public String replaceSpace2(String s) {
        return s == null ? "" : s.replaceAll(" ", "%20");
    }

    // 将字符串中的空格替换为%20
    // 直接遍历转换
    public String replaceSpace3(String string) {
        if (string == null || string.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(string.charAt(i));
            }
        }
        return sb.toString();
    }

    // 如果只允许在原来的char数组的基础上就地操作
    public String replaceSpace2(char[] string) {
        if (string == null || string.length == 0) {
            return null;
        }

        int countSpace = 0;
        int length = 0;
        for (int i = 0; i < string.length; i++) {
            length++;
            // 字符串结束符号
            if (string[i] == '\0') {
                break;
            }
            if (string[i] == ' ') {
                countSpace++;
            }
        }
        // 新字符串的结束位置
        int k = length + countSpace * 2 - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[k--] = '0';
                string[k--] = '2';
                string[k--] = '%';
            } else {
                string[k--] = string[i];
            }
        }
        return String.valueOf(string);
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace2("we are happy."));
        char[] string = new char[100];
        char[] source = {'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', '.', '\0'};
        for (int i = 0; i < source.length; i++) {
            string[i] = source[i];
        }

        System.out.println(replaceSpace.replaceSpace2(string));
    }
}
