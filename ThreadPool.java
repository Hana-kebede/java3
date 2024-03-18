import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        // Creating a thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Adding tasks to the thread pool
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("Task running in thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Shutting down the thread pool gracefully
        executorService.shutdown();

        // Waiting for all tasks to complete before shutting down the program
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        // Checking if all tasks have completed successfully
        if (executorService.isTerminated()) {
            System.out.println("All tasks have completed successfully!");
        } else {
            System.out.println("Some tasks are still running...");
        }
    }

}
