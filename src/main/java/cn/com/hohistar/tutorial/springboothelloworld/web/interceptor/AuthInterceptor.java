package cn.com.hohistar.tutorial.springboothelloworld.web.interceptor;

import cn.com.hohistar.tutorial.springboothelloworld.exception.BizException;
import cn.com.hohistar.tutorial.springboothelloworld.model.Account;
import cn.com.hohistar.tutorial.springboothelloworld.repos.AccountRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AccountRepos accountRepos;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {

//        String path = request.getPathInfo();
//
//        if (path.equals("/account/login")) {
//            return true;
//        }
//
//        String token = request.getHeader("token");
//
//        Account account = accountRepos.findByToken(token);
//
//        if (account == null) {
//            throw new BizException("ACC-002", "Please login firstly.");
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView model)
            throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object object, Exception arg3)
            throws Exception {


    }

}
