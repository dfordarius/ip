public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    public void markDone(){
        this.isDone = true;
    }

    public void markUnDone(){
        this.isDone = false;
    }


    public String printStatus() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}