package JavaPro.SpringBootTask3.MainServlet;

import JavaPro.SpringBootTask3.DB.DBManager;
import JavaPro.SpringBootTask3.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class servletsMain {

    @GetMapping(value = "/")
    public String getMain(Model model){
        ArrayList<Task> arr = DBManager.getAllTask();
        model.addAttribute("task", arr);
        return "indexPage";
    }

    @GetMapping(value = "/details/{taskId}")
    public String details(@PathVariable(name="taskId") Long id, Model model){
        Task task = DBManager.getTask(id);
        model.addAttribute("one_task", task);
        return "detailsPage";
    }

    @PostMapping(value = "/delete_task")
    public String deleteTask(@RequestParam(name = "task_id") Long id){
        System.out.println(id + "Чёто да чёто ");
        DBManager.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping(value = "/save_task")
    public String saveTask (@RequestParam(name = "task_id") Long id,
                            @RequestParam(name = "task_name") String name,
                            @RequestParam(name = "task_description") String description,
                            @RequestParam(name = "task_deadline_date") String deadline_date,
                            @RequestParam(name = "task_completed") boolean completed){

        Task task = new Task();
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadline_date);
        task.setCompleted(completed);

        DBManager.saveTask(id, task);

        return "redirect:/";
    }

    @PostMapping(value = "/add_task")
    public String addTask (@RequestParam(name = "task_name") String name,
                           @RequestParam(name = "task_description") String description,
                           @RequestParam(name = "task_deadline_date") String deadline_date){

        Task task = new Task();
        boolean completed = false;

        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadline_date);
        task.setCompleted(completed);

        DBManager.addTask(task);

        return "redirect:/";
    }

    @GetMapping(value = "/addTask")
    public String getAddTask(){
        return "addTask";
    }
}
