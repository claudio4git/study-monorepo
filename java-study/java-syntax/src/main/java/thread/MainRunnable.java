package thread;

public class MainRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running thread with Runnable");
    }

    public static void main(String[] args) {
        MainRunnable thread = new MainRunnable();
        thread.run();
        System.out.println("Program running");
    }
}
