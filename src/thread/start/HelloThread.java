package thread.start;

public class HelloThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()");
        ByeThread byeThread = new ByeThread();
        byeThread.setName("byeThread");
        byeThread.run();
    }
}
