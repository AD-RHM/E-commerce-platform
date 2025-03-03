package Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    //@RequestMapping(method = RequestMethod.GET,path = "/index")
    @GetMapping("/index")
    public String index() {
        return "/UserUI/index";
    }
    @GetMapping("/homepage")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String homePage(){
        return "/UserUI/HomePage";
    }
    @GetMapping("/login")
    public String login(){
        return "UserUI/LoginPage";
    }
    @GetMapping("/SignIn")
    public String signIn(){
        return "UserUI/SignIn";
    }
    @GetMapping("/ProductPage")
    public String productPage(){
        return "UserUI/ProductPage";
    }
}
