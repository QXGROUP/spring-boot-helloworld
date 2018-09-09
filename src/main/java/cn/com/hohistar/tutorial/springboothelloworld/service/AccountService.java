package cn.com.hohistar.tutorial.springboothelloworld.service;


import cn.com.hohistar.tutorial.springboothelloworld.exception.BizException;
import cn.com.hohistar.tutorial.springboothelloworld.model.Account;
import cn.com.hohistar.tutorial.springboothelloworld.repos.AccountRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountRepos accountRepos;

    @Transactional
    public String login(String username, String password) {

        String token = null;

        Account account = accountRepos.findByUsername(username);
        if (account != null) {
            if (account.getPassword().equals(password)) {
                token = genToken();
                account.setToken(token);
                accountRepos.updateToken(account);
            }
        }
        if (token == null) {
            throw new BizException("ACC-001", "The username or password is invalid.");
        }
        return token;
    }

    private String genToken() {

        return "" + System.currentTimeMillis();
    }

}
