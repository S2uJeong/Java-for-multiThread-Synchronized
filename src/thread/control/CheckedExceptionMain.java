package thread.control;

public class CheckedExceptionMain {
    // main 메서드는 예외를 던질 수 있지만
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    // run() 메서드는 예외를 던질 수 없다.
    static class CheckedRunnable implements Runnable {
        @Override
        public void run() //throws Exception
         {
            // throw new Exception();
        }
    }
}

