package JavaPro.SpringBootTask3.DB;

import JavaPro.SpringBootTask3.Model.Task;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Task> arrayList = new ArrayList<>();
    private static Long id = 6L;
    static {
        arrayList.add(new Task(1L, "Задача первая чёто нужно сделать", "Description1",
                "23.10.2020", false));
        arrayList.add(new Task(2L, "Задача вторая чёто нужно сделать", "Description2",
                "13.02.2019", true));
        arrayList.add(new Task(3L, "Задача третья чёто нужно сделать", "Description3",
                "05.08.2003", false));
        arrayList.add(new Task(4L, "Задача четвёртая чёто нужно сделать","Description4",
                "23.12.2021", true));
        arrayList.add(new Task(5L, "Задача пятая чёто нужно сделать", "Description5",
                "23.10.2022", true));
    }

    public static ArrayList<Task> getAllTask(){
        return arrayList;
    }

    public static Task getTask(Long taskId){
        Task task = new Task();
            for (Task task1 : arrayList){
                if (taskId == task1.getId()){
                    task = task1;
                }
            }
        return task;
    }

    public static void deleteTask(Long id) {
        int i = 0;
        for (Task t : arrayList) {
            if (t.getId() == id) {
                arrayList.remove(i);
                return;
            }
            i++;
        }
    }

    public static void saveTask(Long id, Task task) {
        int i = 0;
        for (Task t : arrayList) {
            if (t.getId() == id) {
                arrayList.set(i, task);
                return;
            }
            i++;
        }
    }

    public static void addTask(Task task){
        task.setId(id);
        arrayList.add(task);
        id++;
    }
}
