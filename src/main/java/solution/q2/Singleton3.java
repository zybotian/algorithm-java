package solution.q2;

public class Singleton3 {

    private Singleton3() {
    }

    private static Singleton3 instance;

    // synchronized，线程安全
    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
