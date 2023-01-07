import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskList {
    private final Map<Integer,Task> tasks=new HashMap<>();
    public void addTask (Task task) {
        this.tasks.put (task.getId(),task);
    }
    public void removeTask (int id) {
        if(this.tasks.containsKey(id)){
            this.tasks.remove(id);
        }else {throw new RuntimeException("неверный id"); };
    }

    public List<Task> getTaskForDate(LocalDate date){
        List <Task> taskForDate=new ArrayList<>();
        for (Task task:tasks.values()) {
            if (task.appearsIn(date)) {
                taskForDate.add(task);
            }
        }
            return taskForDate;


    }
}
