package solution.q2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton7 {
    private Singleton7() {
    }

    public static Singleton7 getInstance() {
        return localInstance.get();
    }

    // 使用thread local为每一个变量提供一个独立的副本
    private static ThreadLocal<Singleton7> localInstance = ThreadLocal.withInitial(() -> new Singleton7());

    public static void main(String[] args) {
        int threadNum = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {

            executorService.submit(() -> {
                        System.out.println(Thread.currentThread().getName() + "#" + Singleton7.getInstance());
                    }
            );
        }
        executorService.shutdown();
    }
}
