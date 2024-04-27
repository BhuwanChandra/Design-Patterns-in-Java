package application.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Singleton {

    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();

    private static Singleton instance = null;

    public static Singleton getInstance() {
        // creating a lock to ensure that only one instance
        // is created when executing in a multithreading environment.
        if (instance == null) {
            lock.lock();
            try {
                // This check is used to ensure that only one instance of the class is created.
                // In a multithreaded environment, it's possible for more than one thread
                // to be blocked on the lock. When the lock is released, multiple threads
                // can enter the locked code section. The inner null check ensures that
                // only one instance is created even if multiple threads enter the locked code section.
                if (instance == null) {
                    instance = new Singleton();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    private Singleton() {
        counter++;
        System.out.println("Instance Created: " + counter);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
