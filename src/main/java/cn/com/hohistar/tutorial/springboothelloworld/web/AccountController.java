package cn.com.hohistar.tutorial.springboothelloworld.web;

import cn.com.hohistar.tutorial.springboothelloworld.exception.BizException;
import cn.com.hohistar.tutorial.springboothelloworld.model.Account;
import cn.com.hohistar.tutorial.springboothelloworld.model.Todo;
import cn.com.hohistar.tutorial.springboothelloworld.service.AccountService;
import cn.com.hohistar.tutorial.springboothelloworld.web.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AccountController {

    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account/login", method = RequestMethod.POST)
    public Result<Account> login(@RequestBody Account account) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("login, params = {}", account);
        }

        Result<Account> res = new Result<>();

        String token = accountService.login(account.getUsername(), account.getPassword());
        account.setToken(token);
        account.setPassword("");

        res.setSucc(true);
        res.setData(account);

        return res;
    }

}
