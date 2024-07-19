package thread.start;

public class ByeThread extends Thread{
    @Override
    public void run() {
        System.out.println(ByeThread.currentThread().getName() + ": I'm byeThread's run");
    }
}
