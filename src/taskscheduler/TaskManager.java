package taskscheduler;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TaskManager {
	
	private Queue<Task> taskQueue = new PriorityQueue<>();
	
	private Set<Integer> processedIds = new HashSet<>();
	
	public void addTask(Task t) {
		if (processedIds.contains(t.getId())) {
			System.out.println("Rejected : Task ID " + t.getId() + " already exists");
			return;
		}
		taskQueue.add(t);
		System.out.println("Added: " + t.getName());
	}
	
	public void processNext() {
		Task t = taskQueue.poll();
		if (t != null) {
			processedIds.add(t.getId());
			System.out.println("processing : " + t);
		}
		else {
			System.out.println("No tasks in the queue");
		}
		
	}
	
	public static void main(String[] args) {
		TaskManager manager = new TaskManager();
		
		// adding tasks out of order
		manager.addTask(new Task(101, "Routine Backup", 5));
		manager.addTask(new Task(102, "Security Patch", 2));
		manager.addTask(new Task(103, "CRITICAL: Database Leak", 1));
		manager.addTask(new Task(104, "Password Update", 4));
		
		
		manager.processNext();
		manager.addTask(new Task(103, "CRITICAL: Database Leak", 1));
	}
	

}
