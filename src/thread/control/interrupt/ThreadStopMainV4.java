package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 * .interrupted() 이용하여 인터럽트 상태 확인 및 변경 까지 처리
 */
public class ThreadStopMainV4 {
    public static void main(String[] args) {
        MyTesk tesk = new MyTesk();
        Thread thread = new Thread(tesk,"work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }
    static class MyTesk implements Runnable {
        @Override
        public void run() {
            while(!Thread.interrupted()) { // 인터럽트 상태 변경 O
                log("작업중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            log("자원 정리");
            log("자원 종료");
        }
    }
}
