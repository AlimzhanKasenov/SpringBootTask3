package JavaPro.SpringBootTask3.MainServlet;

import JavaPro.SpringBootTask3.DB.DBManager;
import JavaPro.SpringBootTask3.Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class servletsMain {

    @GetMapping(value = "/")
    public String getMain(Model model){
        ArrayList<Task> arr = DBManager.getAllTask();
        model.addAttribute("task", arr);
        return "indexPage";
    }
}
