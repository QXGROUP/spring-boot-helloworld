package cn.com.hohistar.tutorial.springboothelloworld.web;

import cn.com.hohistar.tutorial.springboothelloworld.model.Todo;
import cn.com.hohistar.tutorial.springboothelloworld.repos.TodoRepos;
import cn.com.hohistar.tutorial.springboothelloworld.service.TodoService;
import cn.com.hohistar.tutorial.springboothelloworld.web.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {


    @Autowired
    TodoService todoService;

    @RequestMapping("/todo")
    public Result<List<Todo>> findAll() {

        Result<List<Todo>> res = new Result<>();

        List<Todo> todos = todoService.getTodoList();

        res.setSucc(true);
        res.setData(todos);

        return res;
    }
}
