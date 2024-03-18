public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from thread!");
        });
        thread.start();
        thread.join();
        System.out.println("Thread has finished!");
        System.out.println("Is thread still running? " + thread.isAlive());
        System.out.println("Thread name: " + thread.getName());
        thread.setName("MyThread");
        System.out.println("New thread name: " + thread.getName());
        System.out.println("Thread priority: " + thread.getPriority());
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("New thread priority: " + thread.getPriority());
        System.out.println("Thread state: " + thread.getState());
        thread.interrupt();
        System.out.println("Has thread been interrupted? " + thread.isInterrupted());
        Thread.sleep(2000);
        System.out.println("Hello from main thread!");
    }
}
