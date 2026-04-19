      // Java Imports for the main file
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;

// Task class representing the people
class Task implements Comparable<Task> {
    String name; 
    int priority; 
    int arrivalSequence; 

    public Task(String name, int priority, int arrivalSequence) {
        this.name = name;
        this.priority = priority;
        this.arrivalSequence = arrivalSequence;
    }

    
    @Override
    public int compareTo(Task other) {
        // 1st Level Sort: Priority (Lower number = Higher Priority, 1 is first)
        int priorityComparison = Integer.compare(this.priority, other.priority);
        
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        
        // 2nd Level Sort: If priorities are the same, sort by first arrival (FIFO)
        return Integer.compare(this.arrivalSequence, other.arrivalSequence);
    }

    @Override
    public String toString() {
        return name + " [Priority: " + priority + ", Arrival: " + arrivalSequence + "]";
    }
}

// The Main Class
public class Main {

    // Console colors
    static String GREEN = "\u001B[32m";
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";

    

    // Solution 1: Scheduling by arrival order (Ignores Priority)
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

    // Solution 2: Scheduling by Priority, then Arrival Order
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

    // Main method with interactive menu to test both scheduling solutions
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> taskList = new ArrayList<>();

        int priority; // Temporary variable to hold priority input
        int sequenceCounter = 1; // Tracks overall arrival order
        boolean isMenuOpen = true; // control the menu loop

        taskList.add(new Task("Mohamad Radwan", 2, sequenceCounter++));
        taskList.add(new Task("Abdullah Tfran", 2, sequenceCounter++));
        taskList.add(new Task("Naif Alhujaili", 2, sequenceCounter++));
        taskList.add(new Task("Dr. Samer Atawneh", 1, sequenceCounter++));

        System.out.println(GREEN + "=== Welcome to my Task Scheduling System ===" + RESET);

        // Main interface UI
        while (isMenuOpen) {
            System.out.println("Main Menu:");
            System.out.println("1. Add a new person");
            System.out.println("2. Process list by Pure Arrival Order (Solution 1)");
            System.out.println("3. Process list by Priority + Arrival (Solution 2)");
            System.out.println("4. Exit");
            System.out.print("Choose an option 1-4: ");
            
            String choice = scanner.nextLine();

            // Loop to handle user choices
            switch (choice) {
                 case "1":
                    String name = "";
                    
                    // Validation loop for name input
                    while (true) {
                        System.out.print("Enter name: ");
                        name = scanner.nextLine().trim();
                        
                        if (name.isEmpty()) {
                            System.out.println(RED + "Error: Name cannot be empty. Please try again." + RESET);
                        } else if (name.matches(".*\\d.*")) {
                            System.out.println(RED + "Error: Name cannot contain numbers. Please try again." + RESET);
                        } else {
                            break; // Valid name, exit the loop
                        }
                    }
                    
                    // Validation loop for priority input
                    while (true) {
                        System.out.print("Enter priority (1 for Elderly/Disabled, 2 for Normal): ");
                        try {
                            priority = Integer.parseInt(scanner.nextLine());
                            
                            // Check if the input is 1 or 2
                            if (priority == 1 || priority == 2) {
                                break; // Valid input, exit the loop
                            } else {
                                System.out.println(RED + "Invalid input. Priority must be 1 or 2. Please try again." + RESET);
                            }
                        }
                        catch (NumberFormatException e) {
                            // typing any letters or symbols instead of a number
                            System.out.println(RED + "Invalid input. Please enter a valid number (1 or 2)." + RESET);
                        }
                    }

                    // Add the task to our list
                    taskList.add(new Task(name, priority, sequenceCounter));
                    System.out.println(GREEN + "Added: (" + name + ") at arrival sequence " + sequenceCounter + "\n" + RESET);
                    sequenceCounter++;
                    break;

                case "2": // Show the list in pure arrival order
                    System.out.println("----------------");
                    scheduleByArrival(new ArrayList<>(taskList));
                    System.out.println("----------------");
                    break;

                case "3": // Show the list sorted by priority and then arrival order
                    System.out.println("----------------");
                    scheduleByPriority(new ArrayList<>(taskList));
                    System.out.println("----------------");
                    break;

                case "4": // Exit the program
                    isMenuOpen = false;
                    System.out.println(YELLOW + "Thank you for using the system. Goodbye!" + RESET);
                    break;

                default: // Handle invalid menu choices
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    break;
            }
        }
        scanner.close();
    }
}
