package threads;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {
        final  ReentrantLock reentrantLock = new ReentrantLock();
        doWork(reentrantLock);


    }
    public static void doWork(ReentrantLock reentrantLock){
        reentrantLock.lock();
        try {
            // Critical section of the code
            System.out.println("Working...");
        } finally {
            reentrantLock.unlock();  // Ensure the lock is released
        }
    }
}
