package cn.com.hohistar.tutorial.springboothelloworld.service;

import cn.com.hohistar.tutorial.springboothelloworld.model.Todo;
import cn.com.hohistar.tutorial.springboothelloworld.repos.TodoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepos todoRepos;

    @Transactional(readOnly = true)
    public List<Todo> getTodoList() {

        return todoRepos.findAll();
    }

    @Transactional
    public void create(Todo todo) {

        todoRepos.create(todo);

    }

    @Transactional
    public void update(Todo todo) {

        todoRepos.update(todo);

    }


    @Transactional
    public void delete(Todo todo) {

        todoRepos.delete(todo.getId());

    }

}
