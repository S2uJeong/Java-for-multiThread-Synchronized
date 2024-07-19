import thread.start.HelloThread;

/**
 * 스레드 간 실행 순서와 실행 기간을 보장하지 않는다.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        System.out.println(Thread.currentThread().getName() + ": start() 호출 전");
        HelloThread helloThread = new HelloThread();
        helloThread.setName("hellothread");
        helloThread.start();
        System.out.println(Thread.currentThread().getName() + ": start() 호출 후");

        System.out.println(Thread.currentThread().getName() + ": main() end");


        System.out.println("============ start()와 run() 차이 ================");

    }
}