import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final TaskList TASKLIST = new TaskList();
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            addTask(scanner);
                            break;
                        case 2:
                            removeTasks(scanner);
                            break;
                        case 3:
                            printTaskDate(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }
    private static void printMenu() {
        System.out.println(
                "11. Добавить задачу\n" +
                "2. Удалить задачу\n" +
                "3. Получить задачу на указанный день\n" +
                "0. Выход\n"
        );
    }


    private static void addTask(Scanner scanner) {
        String title = readString("Введите название задачи: ", scanner);
        String description = readString("Введите описание задачи: ", scanner);
        TypeTask typeTask = readTaskType(scanner);
        LocalDateTime taskDateTime =readTaskDateTime(scanner) ;
        Repeatability repeatability = readRepeatability(scanner);
        Task task;
        switch (repeatability) {
            case SINGLE:
                task = new SingleTask(title, description, taskDateTime, typeTask);
                break;
            case DAILY:
                task = new DailyTask(title, description, taskDateTime, typeTask);
                break;
            case WEEKLY:
                task = new WeeklyTask(title, description, taskDateTime, typeTask);
                break;
            case MONTHLY:
                task = new MontlyTask(title, description, taskDateTime, typeTask);
                break;
            case YEARLY:
                task = new YearlyTask(title, description, taskDateTime, typeTask);
                break;
            default:
                throw new IllegalArgumentException();
        }
        TASKLIST.addTask(task);
    }

    private static void removeTasks(Scanner scanner){
        while (true){
                System.out.println("Выберите задачу для удаления:");
                String idLine =scanner.nextLine();
                int id=Integer.parseInt(idLine);
                TASKLIST.removeTask(id);
                break;
        }
    }

    private static LocalDateTime readTaskDateTime(Scanner scanner) {
        LocalDate localDate=readTaskDate (scanner);
        LocalTime localTime= readTaskTime(scanner);
        return localDate.atTime(localTime);
    }

    private static Repeatability readRepeatability(Scanner scanner) {
        System.out.println("Выберите тип задачи \n1. Однократная \n2. Ежедневная \n3. Еженедельная\n4. Ежемесячная \n2. Ежегодная");
        while (true) {
            System.out.print("Введите тип задачи: ");
            String taskTypeSelector = scanner.nextLine();
            switch (taskTypeSelector) {
                case "1":
                    return Repeatability.SINGLE;
                case "2":
                    return Repeatability.DAILY;
                case "3":
                    return Repeatability.WEEKLY;
                case "4":
                    return Repeatability.MONTHLY;
                case "5":
                    return Repeatability.YEARLY;

                default:
                    System.out.println("Введен неправильный тип задачи!");
            }
        }
    }

    private static String readString(String text, Scanner scanner) {
        while (true) {
            System.out.print(text);
            String readString =scanner.nextLine();
            if (readString==null||readString.isBlank()){
                System.out.println("Введено пустое значение");
            } else {
                return readString;
            }
        }
    }

    private static void printTaskDate(Scanner scanner) {
        LocalDate localDate = readTaskDate(scanner);
        List<Task> taskForDate = TASKLIST.getTaskForDate(localDate);
        System.out.println("Задачи на " + localDate.format(DATE_FORMAT)+ ": ");
        for (Task task : taskForDate) {
            System.out.println(task.getTypeTask().toString() + task.getTitle() + task.getTaskDateTime().format(TIME_FORMAT) + task.getDescription());
        }
    }

    public static TypeTask readTaskType(Scanner scanner) {
        System.out.println("Выберите тип задачи \n1. Персональная \n2. Рабочая");
        while (true) {
            System.out.print("Введите тип задачи: ");
            String taskTypeSelector = scanner.nextLine();
            switch (taskTypeSelector) {
                case "1":
                    return TypeTask.PERSONAL;
                case "2":
                    return TypeTask.WORK;
                default:
                    System.out.println("Введен неправильный тип задачи!");

            }
        }
    }

    public static LocalDate readTaskDate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите дату задачи в формате dd.MM.yyyy");
                String dateTimeToken = scanner.nextLine();
                return LocalDate.parse(dateTimeToken, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.print("Введен неверный формат даты");

            }
        }
    }
    public static LocalTime readTaskTime(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Введите время задачи в формате HH:mm");
                String dateTimeToken = scanner.nextLine();
                return LocalTime.parse(dateTimeToken, TIME_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.print("Введен неверный формат времени");
            }
        }
    }
}




