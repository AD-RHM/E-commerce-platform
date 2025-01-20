package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index") // Changed path to root for better convention
    public String home(){
        return "index";
    }
    @GetMapping("/home")
    public String homePage(){
        return "HomePage";
    }
    @GetMapping("/Login")
    public String login(){
        return "/Login";
    }
}
