package thread.start.test;

import util.MyLogger;

import static util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {
        log("start");
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    log("A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "threadA");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    log("B");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "threadB");



        threadA.start();
        threadB.start();
        log("end");
    }

}
