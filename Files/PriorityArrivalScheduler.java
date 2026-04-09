// Solution 2: Scheduling by Priority, then Arrival Order

import java.util.PriorityQueue;
import java.util.List;

public class PriorityArrivalScheduler {

            // Console colors declared at the class level
    static String GREEN = "\u001B[32m";
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";

    public static void scheduleByPriority(List<Task> tasks) {
        System.out.println("\n" + YELLOW + "Solution 2: Priority & Arrival Order" + RESET);
        if (tasks.isEmpty()) {
            System.out.println(RED + "No tasks to process." + RESET);
            return;
        }

        PriorityQueue<Task> priorityQueue = new PriorityQueue<>(tasks);
        while (!priorityQueue.isEmpty()) {
            Task currentTask = priorityQueue.poll();
            System.out.println("Executing: " + currentTask);
        }
    }
}