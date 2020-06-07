package solution.q2;

public class Singleton2 {

    private Singleton2() {
    }

    private static Singleton2 instance;

    // 饱汉式，非线程安全
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
