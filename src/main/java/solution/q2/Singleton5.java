package solution.q2;

public class Singleton5 {
    private Singleton5() {
    }

    // 静态内部类，线程安全
    private static class SingletonHolder {
        private static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instance;
    }

}
