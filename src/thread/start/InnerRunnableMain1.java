package thread.start;

/**
 * 내부클래스
 */
import static util.MyLogger.log;

public class InnerRunnableMain1 {
    public static void main(String[] args) {
        log("main() start");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        log("main() end");

    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()");
        }
    }
}
