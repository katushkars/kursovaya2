import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название задачи: ");
        String name =scanner.nextLine();
        System.out.print("Введите название задачи: ");
        String description =scanner.nextLine();
        System.out.print("Введите название задачи: ");
        int number =scanner.nextInt();
        System.out.println("Вы ввели: "+name+ "" +description+ " "+number);




    }
    private static void printeTaskDate (Scanner scanner){
        LocalDate localDate=readDate(scanner);
        List<Task> taskForDate=TASKLIST.getTaskForDate(localDate);
        System.out.println("Задачи на "+localDate.format(DATE_FORMAT));
        for (Task task : taskForDate) {
            System.out.println("");
        }
public static TypeTask readTaskType (Scanner scanner){
            System.out.println ("Выберите тип задачи \n1. Персональная \n2. Рабочая");
            while(true){
                System.out.print ("Введите тип задачи: ");
                String taskTypeSelector = scanner.nextLine();
                switch (taskTypeSelector){
                    case "1":
                        return TypeTask.PERSONAL;
                    case "2":
                        return TypeTask.WORK;ттт
                    default:
                        System.out.println ("Введен неправильный тип задачи!")

                }


            }
        }
        public static TypeTask readTaskDate (Scanner scanner) {
            while(true){
                try{
                    System.out.print("Введите дату и время выполнения задачи");
                    String dateTimeToken =scanner.nextLine();
                    return LocalDateTime.parse (dateTimeToken, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                } catch (DateTimeParseException e) {
                    System.out.print ("Введен неверный формат даты");

                }
            }
        }

    }

}