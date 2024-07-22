package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 * interrupt 사용
 * sleep 상태를 바로 RUNNABLE로 바꿀 수 있다.
 * while문에서는 interrupt 체크를 하지 못함이 아쉬움
 */
public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyTesk tesk = new MyTesk();
        Thread thread = new Thread(tesk,"work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }
    static class MyTesk implements Runnable {
        @Override
        public void run() {
            try {
                while(true) { // 인터럽트 체크 안함
                    log("작업중");
                    Thread.sleep(3000); // 여기서만 인터럽트 발생
                }
            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message : " + e.getMessage());
                log("state=" + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}
