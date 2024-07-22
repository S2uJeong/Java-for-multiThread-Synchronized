package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 * runFlag를 이용해서 작업 중단 지시를 구현
 * 바로 중단되지 않는 문제점이 있음
 */
public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTesk tesk = new MyTesk();
        Thread thread = new Thread(tesk,"work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 runFlag = false");
        tesk.runFlag = false;

    }
    static class MyTesk implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            while(runFlag) {
                log("작업중");
                sleep(3000);
            }
            log("자원 정리");
            log("자원 종료");
        }
    }
}
