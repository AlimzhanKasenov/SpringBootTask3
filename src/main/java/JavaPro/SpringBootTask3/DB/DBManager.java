package JavaPro.SpringBootTask3.DB;

import JavaPro.SpringBootTask3.Model.Task;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Task> arrayList = new ArrayList<>();
    private Long id = 6L;
    static {
        arrayList.add(new Task(1L, "Задача первая чёто нужно сделать", "23.10.2020", false));
        arrayList.add(new Task(2L, "Задача вторая чёто нужно сделать", "13.02.2019", true));
        arrayList.add(new Task(3L, "Задача третья чёто нужно сделать", "05.08.2003", false));
        arrayList.add(new Task(4L, "Задача четвёртая чёто нужно сделать", "23.12.2021", true));
        arrayList.add(new Task(5L, "Задача пятая чёто нужно сделать", "23.10.2022", true));
    }

    public static ArrayList<Task> getAllTask(){
        return arrayList;
    }
}
