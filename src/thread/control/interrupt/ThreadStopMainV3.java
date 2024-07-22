package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 * while 문에서 상태 확인 먼저 한 후, 진행 : isInterrupted()
 */
public class ThreadStopMainV3 {
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
            while(!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 변경 x : 예외가 발생하지 않았기 때
                log("작업중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            log("자원 정리");
            log("자원 종료");
        }
    }
}
