package cn.com.hohistar.tutorial.springboothelloworld.repos;

import cn.com.hohistar.tutorial.springboothelloworld.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface AccountRepos {

    @Select("select * from account where username = #{username}")
    Account findByUsername(String username);

    @Select("select * from account where token = #{token}")
    Account findByToken(String token);


    @Update("update account set token = #{token} where id = #{id}")
    void updateToken(Account account);



}
