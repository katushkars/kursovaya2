import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    private final String title;
    private final String description;
    private final LocalDateTime taskDateTime;
    private final TypeTask typeTask;
    private int id;
    private int counter =0;

    public Task(String title, String description, LocalDateTime taskDateTime, TypeTask typeTask) {
        this.title = title;
        this.description = description;
        this.taskDateTime = taskDateTime;
        this.typeTask = typeTask;
        this.id = counter++;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTaskDateTime() {
        return taskDateTime;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public int getId() {
        return id;
    }
    public abstract boolean appearsIn(LocalDate localDate);
    public abstract Repeatability getRepeatabilityType ();

    }



