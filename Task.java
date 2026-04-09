// Task class representing individual people

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