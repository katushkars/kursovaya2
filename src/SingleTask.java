import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task{

    public SingleTask(String title, String description, LocalDateTime taskDateTime, TypeTask typeTask) {
        super(title, description, taskDateTime, typeTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.equals(this.getTaskDateTime().toLocalDate());
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.SINGLE;
    }
}
