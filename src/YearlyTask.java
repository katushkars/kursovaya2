import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, String description, LocalDateTime taskDateTime, TypeTask typeTask, int id) {
        super(title, description, taskDateTime, typeTask, id);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        LocalDate taskDate=this.getTaskDateTime().toLocalDate();
        return localDate.equals(taskDate)|| (localDate.isAfter(taskDate) && localDate.getDayOfYear()==taskDate.getDayOfYear());
    }

    @Override
    public Repeatability getRepeatabilityType() {
        return Repeatability.YEARLY;
    }
}
