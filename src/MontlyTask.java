import java.time.LocalDate;
import java.time.LocalDateTime;

public class MontlyTask extends Task{
    public MontlyTask(String title, String description, LocalDateTime taskDateTime, TypeTask typeTask) {
        super(title, description, taskDateTime, typeTask);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate=this.getTaskDateTime().toLocalDate();
        return localDate.equals(taskDate)|| (localDate.isAfter(taskDate) && localDate.getDayOfMonth()==taskDate.getDayOfMonth());
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.MONTHLY;
    }
}
