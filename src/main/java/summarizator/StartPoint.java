package summarizator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StartPoint {

    @GetMapping("/start")
    public String welcome() {
        return "index";
    }

    @GetMapping("createUser")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "start";
    }

    @PostMapping("/createUser")
    public String createUsersubmit (@ModelAttribute User user) {
        return "added-user";
    }
}
