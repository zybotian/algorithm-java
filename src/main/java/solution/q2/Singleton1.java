package solution.q2;

/**
 * 单例模式
 */
public class Singleton1 {

    private Singleton1() {
    }

    // 饿汉式,线程安全
    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}
