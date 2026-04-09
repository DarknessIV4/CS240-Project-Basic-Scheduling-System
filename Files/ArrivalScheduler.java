    // Solution 1: Scheduling by arrival order (Ignores Priority)

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class ArrivalScheduler {
        // Console colors declared at the class level
    static String GREEN = "\u001B[32m";
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";

    public static void scheduleByArrival(List<Task> tasks) {
        System.out.println("\n" + YELLOW + "Solution 1: Pure Arrival Order" + RESET);
        if (tasks.isEmpty()) {
            System.out.println(RED + "No tasks to process." + RESET);
            return;
        }
        
        Queue<Task> queue = new LinkedList<>(tasks);
        while (!queue.isEmpty()) {
            Task currentTask = queue.poll();
            System.out.println("Executing: " + currentTask);
        }
    } 
}
