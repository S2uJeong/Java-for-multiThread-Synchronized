package thread.control.join;
import static util.ThreadUtils.sleep;
import static util.MyLogger.log;

/**
 * join 사용을 안 했을 시, 의도와는 다른 결과값 출력
 * 의도 : 1 ~ 100 의 수의 합을 여러 스레드로 나눠 계산하여 빠르게 계산하고 마지막에 합친 값을 반환한다.
 */
public class JoinMainV1 {
    public static void main(String[] args) {
        log("start");
        SumTask sumTask1 = new SumTask(1,50);
        SumTask sumTask2 = new SumTask(51,100);
        Thread thread1 = new Thread(sumTask1, "thread-1");
        Thread thread2 = new Thread(sumTask2, "thread-2");
        thread1.start();
        thread2.start();

        log("task1.result = " + sumTask1.result);
        log("task2.result = " + sumTask2.result);
        int sumAll = sumTask1.result + sumTask2.result;
        log("task1 + task2 = " + sumAll);
        log("end");
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);

        }
    }

}
