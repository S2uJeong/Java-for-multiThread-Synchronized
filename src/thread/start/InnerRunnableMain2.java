package thread.start;

import static util.MyLogger.log;

/**
 * 익명 클래스
 */
public class InnerRunnableMain2 {
    public static void main(String[] args) {
        log("main() start");
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();
        log("main() end");

    }
}
