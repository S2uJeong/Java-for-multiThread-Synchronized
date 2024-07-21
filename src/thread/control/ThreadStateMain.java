package thread.control;

import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start()");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState());

        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState());


    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("start");
            log("myTread.state2 = " + Thread.currentThread().getState());
            log("sleep() start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("myThread.state4 = " + Thread.currentThread().getState());

        }
    }
}
