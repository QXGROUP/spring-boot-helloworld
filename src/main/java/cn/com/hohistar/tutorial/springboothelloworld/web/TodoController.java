package cn.com.hohistar.tutorial.springboothelloworld.web;

import cn.com.hohistar.tutorial.springboothelloworld.model.Todo;
import cn.com.hohistar.tutorial.springboothelloworld.repos.TodoRepos;
import cn.com.hohistar.tutorial.springboothelloworld.service.TodoService;
import cn.com.hohistar.tutorial.springboothelloworld.web.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public Result<Todo> create(@RequestBody Todo todo) {

        Result<Todo> res = new Result<>();

        if (todo != null) {

            todoService.create(todo);

            res.setSucc(true);
            res.setData(todo);
        }

        return res;
    }


    @RequestMapping(value = "/todo", method = RequestMethod.PUT)
    public Result<Todo> update(@RequestBody Todo todo) {

        Result<Todo> res = new Result<>();

        if (todo != null) {

            todoService.update(todo);

            res.setSucc(true);
            res.setData(todo);
        }

        return res;
    }


    @RequestMapping(value = "/todo", method = RequestMethod.DELETE)
    public Result<Todo> delete(@RequestBody Todo todo) {

        Result<Todo> res = new Result<>();

        if (todo != null) {

            todoService.delete(todo);

            res.setSucc(true);
        }

        return res;
    }


}
