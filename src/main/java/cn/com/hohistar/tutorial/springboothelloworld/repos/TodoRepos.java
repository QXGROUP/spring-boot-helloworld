package cn.com.hohistar.tutorial.springboothelloworld.repos;

import cn.com.hohistar.tutorial.springboothelloworld.model.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoRepos {

    @Select("select * from todo")
    List<Todo> findAll();


    @Insert("insert into todo(title, desc) values (#{title}, #{desc})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Long.class)
    void create(Todo todo);

    @Update("update todo set title = #{title}, desc = #{desc} where id = #{id}")
    void update(Todo todo);

    @Delete("delete from todo where id = #{id}")
    void delete(@Param("id") Long id);

}
