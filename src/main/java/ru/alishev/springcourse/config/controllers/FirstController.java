package ru.alishev.springcourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false
    ) String name, @RequestParam(value = "surname", required = false) String surname, Model model) {

        model.addAttribute("message", "Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model) {

        switch (action){
            case "multiplication":
                model.addAttribute("result", a*b);
                break;
            case "addition":
                model.addAttribute("result", a+b);
                break;
                case "subtraction":
                    model.addAttribute("result", a-b);
                    break;
                    case "division":
                        model.addAttribute("result", a/b);
                        break;
                        default:
                            break;
        }
        return "first/calculator";

    }
}
