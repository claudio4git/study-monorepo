package thread;

public class MainThread extends Thread {
    public void run() {
        System.out.println("Running thread with Thread");
    }

    public static void main(String[] args) {
        MainThread thread = new MainThread();
        thread.start();
        System.out.println("Program running");
    }
}
