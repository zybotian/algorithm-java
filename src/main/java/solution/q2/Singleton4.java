package solution.q2;

public class Singleton4 {
    private Singleton4() {
    }

    private volatile static Singleton4 instance;

    // 双重检查synchronized，线程安全
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
