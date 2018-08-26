package cn.com.hohistar.tutorial.springboothelloworld.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String greeting() {
        return "hello";
    }

    @RequestMapping("/hello")
    public String sayHello(@RequestParam("name") String name) {
        return "Hello " + name + "!";
    }

}
