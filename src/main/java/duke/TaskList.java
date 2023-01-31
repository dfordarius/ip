package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.ToDo;

import java.util.ArrayList;

/**
 * TaskList contains the list of Tasks and methods to modify the list.
 */
public class TaskList {
    private ArrayList<Task> listOfTasks;

    /**
     * Constructor for TaskList without any saved data.
     */
    public TaskList() {
        this.listOfTasks = new ArrayList<>();
    }

    /**
     * Constructor for TaskList with data previously stored in the file.
     *
     * @param taskList contains data of saved task obtains from file.
     * @throws DukeException if duke cannot recognise the command.
     */
    public TaskList(ArrayList<String> taskList) throws DukeException {
        this.listOfTasks = new ArrayList<>();
        for (String data : taskList) {
            listOfTasks.add(Task.loadTask(data));
        }
    }


    /**
     * Creates a new Deadline object.
     *
     * @param description Description of the Deadline object.
     * @param by          The due date of the deadline.
     */
    public void addDeadline(String description, String by) throws DukeException {
        Deadline deadline = new Deadline(description, by, false);
        listOfTasks.add(deadline);
    }

    /**
     * Creates a new ToDo object.
     *
     * @param description Description of the ToDo object.
     */
    public void addToDo(String description) {
        ToDo todo = new ToDo(description, false);
        listOfTasks.add(todo);
    }


    /**
     * Creates a new Event object.
     *
     * @param description Description of the Event object.
     * @param from        The start of the event.
     * @param to          The end of the event.
     */

    public void addEvent(String description, String from, String to) throws DukeException {
        Event event = new Event(description, from, to, false);
        listOfTasks.add(event);
    }

    /**
     * Deletes task in the task list.
     *
     * @param index Index of task to be deleted.
     * @return The deleted task.
     */
    public Task deleteTask(int index) {
        return listOfTasks.remove(index);
    }

    /**
     * Marks the task as done.
     *
     * @param index Index of task to be marked done.
     */
    public void markTask(int index) {
        listOfTasks.get(index).markDone();
    }

    /**
     * Unmark the task.
     *
     * @param index Index of task to be marked unDone.
     */
    public void unmarkTask(int index) {
        listOfTasks.get(index).markUnDone();
    }

    /**
     * Prints the tasks in the list for the user.
     */
    public void printList() {
        int i = 1;
        System.out.println("\n\tHere are the tasks in your list:");
        for (Task task : listOfTasks) {
            System.out.println("\t"
                    + i
                    + ". "
                    + task.toString());
            i++;
        }
    }

    /**
     * Finds specific task(s) that match the keyword inputted by user in the task list.
     *
     * @param keyword Specific keyword(s) of task to be found in the task list.
     * @return ArrayList consisting of tasks that match the keyword.
     */
    public ArrayList<String> findTaskMatchingKeyword(String ... keyword) {
        ArrayList<String> matchingTasks = new ArrayList<>();
        for (Task task : listOfTasks) {
            for (String matching : keyword) {
                if (task.getDescription().contains(matching)) {
                    matchingTasks.add(task.toString());
                }
            }
        }
        return matchingTasks;
    }

    /**
     * Gets the size of the task list.
     *
     * @return Size of the task list.
     */
    public int getSize() {
        return listOfTasks.size();
    }

    /**
     * Checks if the task list is empty.
     *
     * @return Is the list empty.
     */
    public boolean isEmpty() {
        return listOfTasks.isEmpty();
    }

    /**
     * Gets the task at the specific index in the task list.
     *
     * @param index Index of task in the task list.
     * @return Task at the specific index of the task list.
     */
    public Task getTask(int index) {
        return listOfTasks.get(index);
    }

    /**
     * Gets the list of tasks.
     *
     * @return Arraylist which consist of the tasks.
     */
    public ArrayList<Task> getListOfTasks() {
        return listOfTasks;
    }
}
