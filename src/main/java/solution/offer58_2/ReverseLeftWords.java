package solution.offer58_2;

public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        char[] chs = s.toCharArray();
        reverse(chs, 0, n - 1);
        reverse(chs, n, chs.length - 1);
        reverse(chs, 0, chs.length - 1);
        return new String(chs);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseLeftWords test = new ReverseLeftWords();
        System.out.println(test.reverseLeftWords("1234567", 3));
    }
}

