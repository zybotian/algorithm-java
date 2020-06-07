package solution.q2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class Singleton8 {
    private Singleton8() {
    }

    private static AtomicReference<Singleton8> instance = new AtomicReference<>();

    // atomic reference + CAS实现线程安全的单例模式
    public static Singleton8 getInstance() {
        for (; ; ) {
            Singleton8 current = instance.get();
            if (current != null) {
                return current;
            }
            current = new Singleton8();
            if (instance.compareAndSet(null, current)) {
                return current;
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {

            executorService.submit(() -> {
                        System.out.println(Thread.currentThread().getName() + "#" + Singleton8.getInstance());
                    }
            );
        }
        executorService.shutdown();
    }
}
