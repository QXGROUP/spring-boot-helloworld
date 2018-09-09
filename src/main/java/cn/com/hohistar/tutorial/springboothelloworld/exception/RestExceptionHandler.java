package cn.com.hohistar.tutorial.springboothelloworld.exception;


import cn.com.hohistar.tutorial.springboothelloworld.web.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(BizException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result<Object> handleBizException(BizException ex) {

        Result<Object> res = new Result<>();
        res.setCode(ex.getCode());
        res.setMsg(ex.getMsg());
        return res;
    }


    @RequestMapping(produces = "application/json")
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Result<Object> handleNotBizException(Throwable ex) {

        Result<Object> res = new Result<>();
        res.setCode("SYS-001");
        res.setMsg("The server is unavailable, please contract to administrator.");
        return res;
    }

}
