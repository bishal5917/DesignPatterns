package Structural.CompositeMethod;

import java.util.ArrayList;
import java.util.List;

// This pattern lets client treat individual objects and
// composition of objects uniformly

// Lets take the scenario of a task management system
//component
interface Task {
    String getTitle();

    void setTitle(String title);

    void display();
}

// SimpleTask (leaf)
class SimpleTask implements Task {

    private String title;

    public SimpleTask() {
    }

    public SimpleTask(String name) {
        this.title = name;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Simple task: " + title);
    }

}

// Now the composite task, which also implements the task interface
class TaskList implements Task {

    private List<Task> tasks;
    private String title;

    public TaskList(String name) {
        this.tasks = new ArrayList<>();
        this.title = name;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        for (Task task : tasks) {
            System.out.println("Simple Task: " + task.getTitle() + " from " + this.title);
        }
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}

public class Solution {
    public static void main(String[] args) {
        // Creating a simple task
        Task simpleTask = new SimpleTask();
        simpleTask.setTitle("Making Report");
        simpleTask.display();

        // Creating a composite task
        TaskList phase1 = new TaskList("FIRST PHASE");
        phase1.addTask(new SimpleTask("Design Algorithms"));
        phase1.addTask(new SimpleTask("Implement Algorithms"));
        phase1.addTask(new SimpleTask("Generate Report"));
        phase1.display();
    }
}

// This provides help when individual components and a group of components
// are required to be treated uniformly and consistently
