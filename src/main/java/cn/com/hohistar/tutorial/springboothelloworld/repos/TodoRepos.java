package cn.com.hohistar.tutorial.springboothelloworld.repos;

import cn.com.hohistar.tutorial.springboothelloworld.model.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TodoRepos {

    @Select("select * from todo")
    public List<Todo> findAll();



}
